# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

temp_paths=()

temp_path() {
    local path
    path="$(mktemp -d "${TMPDIR:-/tmp}/$2.XXXXXX")"
    temp_paths+=("$path")
    printf -v "$1" '%s' "$path"
}

remove_temp_paths() {
    local path
    for path in ${temp_paths[@]+"${temp_paths[@]}"}; do
        if [[ -e "$path" ]]; then
            chmod -R u+w "$path" 2>/dev/null || true
            rm -rf -- "$path"
        fi
    done
    temp_paths=()
}

exit_on_signals() {
    trap 'exit 129' HUP
    trap 'trap - INT; kill -INT "$$"' INT
    trap 'exit 143' TERM
}
