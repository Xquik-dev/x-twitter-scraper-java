// SPDX-FileCopyrightText: 2026 Xquik contributors
// SPDX-License-Identifier: Apache-2.0

package main

import (
	"bytes"
	"crypto/sha256"
	"encoding/hex"
	"encoding/json"
	"encoding/xml"
	"fmt"
	"io"
	"os"
	"strconv"
)

type count struct{ Covered, Missed uint64 }
type jacocoReport struct {
	XMLName  xml.Name `xml:"report"`
	Counters []struct {
		Type    string `xml:"type,attr"`
		Covered string `xml:"covered,attr"`
		Missed  string `xml:"missed,attr"`
	} `xml:"counter"`
}

var metrics = []string{"INSTRUCTION", "BRANCH", "LINE", "METHOD"}

func readReport(path string) (map[string]count, string, error) {
	data, err := os.ReadFile(path)
	if err != nil {
		return nil, "", err
	}
	decoder := xml.NewDecoder(bytes.NewReader(data))
	var parsed jacocoReport
	if err := decoder.Decode(&parsed); err != nil {
		return nil, "", fmt.Errorf("%s: %w", path, err)
	}
	for {
		token, err := decoder.Token()
		if err == io.EOF {
			break
		}
		if err != nil {
			return nil, "", fmt.Errorf("%s: %w", path, err)
		}
		if text, ok := token.(xml.CharData); !ok || len(bytes.TrimSpace(text)) != 0 {
			return nil, "", fmt.Errorf("%s: trailing XML", path)
		}
	}
	counts := make(map[string]count)
	for _, counter := range parsed.Counters {
		if counter.Type == "CLASS" || counter.Type == "COMPLEXITY" {
			continue
		}
		covered, ce := strconv.ParseUint(counter.Covered, 10, 31)
		missed, me := strconv.ParseUint(counter.Missed, 10, 31)
		if _, duplicate := counts[counter.Type]; duplicate || ce != nil || me != nil || covered+missed > 1<<31-1 {
			return nil, "", fmt.Errorf("%s: invalid %s counter", path, counter.Type)
		}
		counts[counter.Type] = count{covered, missed}
	}
	for _, metric := range metrics {
		counter, exists := counts[metric]
		if !exists || (metric != "BRANCH" && counter.Covered == 0 && counter.Missed == 0) {
			return nil, "", fmt.Errorf("%s: missing or empty %s counter", path, metric)
		}
	}
	if len(counts) != 4 {
		return nil, "", fmt.Errorf("%s: unknown native counter", path)
	}
	digest := sha256.Sum256(data)
	return counts, hex.EncodeToString(digest[:]), nil
}

func passes(parent, candidate count) bool {
	if candidate.Missed <= parent.Missed {
		return true
	}
	if parent.Covered == 0 && parent.Missed == 0 {
		return false
	}
	return candidate.Covered*(parent.Covered+parent.Missed) >= parent.Covered*(candidate.Covered+candidate.Missed)
}

func fail(message string, code int) {
	json.NewEncoder(os.Stdout).Encode(map[string]string{"error": message})
	os.Exit(code)
}

func main() {
	if len(os.Args) != 3 {
		fail("Pass fresh full-source parent.xml and candidate.xml reports.", 64)
	}
	parent, parentDigest, err := readReport(os.Args[1])
	if err != nil {
		fail(err.Error(), 2)
	}
	candidate, candidateDigest, err := readReport(os.Args[2])
	if err != nil {
		fail(err.Error(), 2)
	}
	failed := make([]string, 0)
	for _, metric := range metrics {
		if !passes(parent[metric], candidate[metric]) {
			failed = append(failed, metric)
		}
	}
	result := struct {
		Parent, Candidate             map[string]count
		ParentSHA256, CandidateSHA256 string
		Failures                      []string
	}{parent, candidate, parentDigest, candidateDigest, failed}
	if err := json.NewEncoder(os.Stdout).Encode(result); err != nil {
		fmt.Fprintln(os.Stderr, err)
		os.Exit(2)
	}
	if len(failed) != 0 {
		os.Exit(1)
	}
}
