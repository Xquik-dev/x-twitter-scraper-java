#!/bin/sh

# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

# Runs the Gradle distribution that gradle/wrapper/gradle-wrapper.properties pins.
# The first run downloads it and installs it only when its SHA-256 matches
# distributionSha256Sum. Later runs reuse that install.

set -eu

properties="$(cd -- "$(dirname -- "$0")" && pwd -P)/gradle/wrapper/gradle-wrapper.properties"

property() {
    sed -n "s/^$1=//p" "$properties" | tr -d '\r' | sed 's/\\:/:/g'
}

url="$(property distributionUrl)"
sha256="$(property distributionSha256Sum)"
if [ -z "$url" ] || [ -z "$sha256" ]; then
    echo "$properties must set distributionUrl and distributionSha256Sum." >&2
    exit 1
fi
archive="${url##*/}"
install_root="${GRADLE_USER_HOME:-$HOME/.gradle}/wrapper/dists/${archive%.zip}/$sha256"
distribution="${archive%-*}"
gradle="$install_root/$distribution/bin/gradle"

if [ ! -x "$gradle" ]; then
    mkdir -p "$install_root"
    download="$(mktemp -d "$install_root/download.XXXXXX")"
    trap 'rm -rf -- "$download"' EXIT
    trap 'exit 130' INT
    trap 'exit 143' TERM
    curl --fail --silent --show-error --location --retry 3 --output "$download/$archive" "$url"
    if command -v sha256sum >/dev/null 2>&1; then
        actual="$(sha256sum "$download/$archive")"
    else
        actual="$(shasum -a 256 "$download/$archive")"
    fi
    actual="${actual%% *}"
    if [ "$actual" != "$sha256" ]; then
        echo "$url has SHA-256 $actual, not the pinned $sha256. Nothing was installed." >&2
        exit 1
    fi
    unzip -q "$download/$archive" -d "$download"
    # A parallel run may install first. Then this rename fails and its install stays.
    if ! mv "$download/$distribution" "$install_root/" 2>/dev/null && [ ! -x "$gradle" ]; then
        echo "$archive holds no $distribution/bin/gradle to install into $install_root." >&2
        exit 1
    fi
    rm -rf -- "$download"
    trap - EXIT INT TERM
fi

exec "$gradle" "$@"
