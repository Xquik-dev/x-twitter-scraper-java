// SPDX-FileCopyrightText: 2026 Xquik contributors
// SPDX-License-Identifier: Apache-2.0

package main

import (
	"encoding/json"
	"errors"
	"fmt"
	"os"
	"os/exec"
	"path/filepath"
	"reflect"
	"strings"
	"testing"
)

var binary string

func TestMain(m *testing.M) {
	dir, err := os.MkdirTemp("", "coverage-gate-test-")
	if err != nil {
		panic(err)
	}
	binary = filepath.Join(dir, "coverage-gate")
	out, err := exec.Command("go", "build", "-o", binary, "main.go").CombinedOutput()
	if err != nil {
		fmt.Fprint(os.Stderr, string(out))
		os.RemoveAll(dir)
		os.Exit(1)
	}
	code := m.Run()
	os.RemoveAll(dir)
	os.Exit(code)
}

func report(covered, missed string) string {
	var xml strings.Builder
	xml.WriteString(`<report><package name="nested"><counter type="LINE" covered="99" missed="1"/></package>`)
	for _, metric := range []string{"INSTRUCTION", "BRANCH", "LINE", "METHOD"} {
		fmt.Fprintf(&xml, `<counter type="%s" covered="%s" missed="%s"/>`, metric, covered, missed)
	}
	return xml.String() + `</report>`
}

func run(t *testing.T, parent, candidate string) ([]byte, error) {
	t.Helper()
	dir := t.TempDir()
	for name, content := range map[string]string{"parent.xml": parent, "candidate.xml": candidate} {
		if err := os.WriteFile(filepath.Join(dir, name), []byte(content), 0600); err != nil {
			t.Fatal(err)
		}
	}
	return exec.Command(binary, filepath.Join(dir, "parent.xml"), filepath.Join(dir, "candidate.xml")).CombinedOutput()
}

func assertExit(t *testing.T, err error, expected int) {
	t.Helper()
	if expected == 0 && err == nil {
		return
	}
	var status *exec.ExitError
	if !errors.As(err, &status) || status.ExitCode() != expected {
		t.Fatalf("expected exit %d, got %v", expected, err)
	}
}

func TestCoveragePolicy(t *testing.T) {
	for _, tc := range []struct {
		name, covered, missed string
		passes                bool
	}{
		{"unchanged below former floors", "1", "9", true},
		{"better ratio with more uncovered items", "11", "10", true},
		{"equal ratio with more uncovered items", "2", "18", true},
		{"covered code removal", "0", "9", true},
		{"worse ratio with more uncovered items", "1", "10", false},
	} {
		t.Run(tc.name, func(t *testing.T) {
			out, err := run(t, report("1", "9"), report(tc.covered, tc.missed))
			expectedExit := 1
			if tc.passes {
				expectedExit = 0
			}
			assertExit(t, err, expectedExit)
			var result struct {
				Candidate map[string]struct{ Covered, Missed uint64 }
			}
			if err := json.Unmarshal(out, &result); err != nil {
				t.Fatalf("invalid JSON: %s", out)
			}
			if len(result.Candidate) != 4 {
				t.Fatalf("missing native counters: %s", out)
			}
		})
	}
}

func TestEachNativeCounterCanRejectARegression(t *testing.T) {
	for _, metric := range []string{"INSTRUCTION", "BRANCH", "LINE", "METHOD"} {
		t.Run(metric, func(t *testing.T) {
			candidate := strings.Replace(report("1", "9"), `type="`+metric+`" covered="1" missed="9"`, `type="`+metric+`" covered="1" missed="10"`, 1)
			out, err := run(t, report("1", "9"), candidate)
			assertExit(t, err, 1)
			var result struct{ Failures []string }
			if err := json.Unmarshal(out, &result); err != nil {
				t.Fatal(err)
			}
			if !reflect.DeepEqual(result.Failures, []string{metric}) {
				t.Fatalf("wrong failed metric: %s", out)
			}
		})
	}
}

func TestReportsRetainDistinctNativeCounts(t *testing.T) {
	parent := `<report><counter type="INSTRUCTION" covered="1" missed="2"/><counter type="BRANCH" covered="3" missed="4"/><counter type="LINE" covered="5" missed="6"/><counter type="METHOD" covered="7" missed="8"/></report>`
	candidate := `<report><counter type="INSTRUCTION" covered="9" missed="2"/><counter type="BRANCH" covered="10" missed="4"/><counter type="LINE" covered="11" missed="6"/><counter type="METHOD" covered="12" missed="8"/></report>`
	out, err := run(t, parent, candidate)
	assertExit(t, err, 0)
	var result struct {
		Parent, Candidate map[string]struct{ Covered, Missed uint64 }
	}
	if err := json.Unmarshal(out, &result); err != nil {
		t.Fatal(err)
	}
	expectedParent := map[string]struct{ Covered, Missed uint64 }{"INSTRUCTION": {1, 2}, "BRANCH": {3, 4}, "LINE": {5, 6}, "METHOD": {7, 8}}
	expectedCandidate := map[string]struct{ Covered, Missed uint64 }{"INSTRUCTION": {9, 2}, "BRANCH": {10, 4}, "LINE": {11, 6}, "METHOD": {12, 8}}
	if !reflect.DeepEqual(result.Parent, expectedParent) || !reflect.DeepEqual(result.Candidate, expectedCandidate) {
		t.Fatalf("wrong native counts: %s", out)
	}
}

func TestBranchlessSourceHasValidNativeCounts(t *testing.T) {
	xml := `<report><counter type="INSTRUCTION" covered="1" missed="2"/><counter type="BRANCH" covered="0" missed="0"/><counter type="LINE" covered="3" missed="4"/><counter type="METHOD" covered="5" missed="6"/><counter type="CLASS" covered="1" missed="2"/><counter type="COMPLEXITY" covered="3" missed="4"/></report>`
	out, err := run(t, xml, xml)
	assertExit(t, err, 0)
	var result struct {
		Candidate map[string]struct{ Covered, Missed uint64 }
	}
	if err := json.Unmarshal(out, &result); err != nil {
		t.Fatal(err)
	}
	expected := map[string]struct{ Covered, Missed uint64 }{"INSTRUCTION": {1, 2}, "BRANCH": {0, 0}, "LINE": {3, 4}, "METHOD": {5, 6}}
	if !reflect.DeepEqual(result.Candidate, expected) {
		t.Fatalf("wrong branchless counts: %s", out)
	}
}

func TestNativeRatiosUseExactArithmetic(t *testing.T) {
	out, err := run(t, report("1073741823", "1073741822"), report("1073741824", "1073741823"))
	assertExit(t, err, 1)
	var result struct{ Failures []string }
	if err := json.Unmarshal(out, &result); err != nil {
		t.Fatal(err)
	}
	if !reflect.DeepEqual(result.Failures, []string{"INSTRUCTION", "BRANCH", "LINE", "METHOD"}) {
		t.Fatalf("rounded ratio accepted: %s", out)
	}
}

func TestLargestNativeTotalRemainsValid(t *testing.T) {
	out, err := run(t, report("2147483646", "1"), report("2147483646", "1"))
	assertExit(t, err, 0)
	var result struct {
		Candidate map[string]struct{ Covered, Missed uint64 }
	}
	if err := json.Unmarshal(out, &result); err != nil {
		t.Fatal(err)
	}
	expected := map[string]struct{ Covered, Missed uint64 }{"INSTRUCTION": {2147483646, 1}, "BRANCH": {2147483646, 1}, "LINE": {2147483646, 1}, "METHOD": {2147483646, 1}}
	if !reflect.DeepEqual(result.Candidate, expected) {
		t.Fatalf("wrong native limit counts: %s", out)
	}
}

func TestInvalidReportsCannotPass(t *testing.T) {
	for _, fixture := range []struct{ name, xml string }{
		{"missing counters", `<report/>`},
		{"wrong root", `<other>` + report("1", "9") + `</other>`},
		{"multiple reports", report("1", "9") + report("1", "9")},
		{"negative counts", report("-1", "9")},
		{"fractional counts", report("1.5", "9")},
		{"covered count exceeds native int32", report("2147483648", "0")},
		{"missed count exceeds native int32", report("1", "2147483648")},
		{"total exceeds native int32", report("1", "2147483647")},
		{"empty source", report("0", "0")},
		{"duplicate metric", strings.Replace(report("1", "9"), `type="METHOD"`, `type="LINE"`, 1)},
		{"missing covered count", strings.Replace(report("1", "9"), `type="METHOD" covered="1"`, `type="METHOD"`, 1)},
		{"truncated report", strings.TrimSuffix(report("1", "9"), `</report>`)},
	} {
		for _, side := range []string{"parent", "candidate"} {
			t.Run(side+"/"+fixture.name, func(t *testing.T) {
				parent, candidate := report("1", "9"), fixture.xml
				if side == "parent" {
					parent, candidate = fixture.xml, parent
				}
				out, err := run(t, parent, candidate)
				assertExit(t, err, 2)
				var diagnostic struct{ Error string }
				if err := json.Unmarshal(out, &diagnostic); err != nil || !strings.Contains(diagnostic.Error, side+".xml") {
					t.Fatalf("missing report diagnostic: %s", out)
				}
			})
		}
	}
}
