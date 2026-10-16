# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

temp_paths=()

remove_temp_paths() {
    local path
    for path in ${temp_paths[@]+"${temp_paths[@]}"}; do
        if [[ -e "$path" ]]; then
            chmod -R u+w "$path"
            rm -rf -- "$path"
        fi
    done
    temp_paths=()
}

exit_on_signals() {
    trap 'exit 129' HUP
    trap 'exit 130' INT
    trap 'exit 143' TERM
}
