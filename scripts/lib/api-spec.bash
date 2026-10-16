# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

readonly default_spec="https://xquik.com/openapi.json"
readonly spec_source="${XQUIK_OPENAPI_SPEC:-$default_spec}"
case "$spec_source" in
    http://* | https://*) spec_file="" ;;
    /*) spec_file="$spec_source" ;;
    *) spec_file="$PWD/$spec_source" ;;
esac

spec_unreadable() {
    echo "Could not read the API spec from $spec_source. Check network access, or set XQUIK_OPENAPI_SPEC to a local copy of $default_spec." >&2
    exit 1
}

read_spec() {
    if [[ -z "$spec_file" ]]; then
        spec_file="$workspace/spec.json"
        curl --fail --silent --location --max-time 60 --output "$spec_file" -- "$spec_source" 2>/dev/null ||
            spec_unreadable
    fi
    jq -e '(type == "object") and (.paths | type == "object")' "$spec_file" >/dev/null 2>&1 ||
        spec_unreadable
}
