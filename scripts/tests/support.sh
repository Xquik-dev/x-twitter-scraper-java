#!/usr/bin/env bash

# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

tests_root="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")/../.." && pwd)"
readonly tests_root

source "$tests_root/scripts/lib/temp-paths.bash"

readonly local_tools=(bash git jq)

readonly remote_tools=(codeql curl gh gpg java security shellcheck uvx)

create_sandbox() {
    local tool tool_path
    temp_path sandbox xquik-java-script-test
    sandbox="$(cd -- "$sandbox" && pwd -P)"
    sandbox_repo="$sandbox/repo"
    sandbox_bin="$sandbox/bin"
    sandbox_logs="$sandbox/logs"
    mkdir -p "$sandbox_repo" "$sandbox_bin" "$sandbox_logs" "$sandbox/tmp" "$sandbox/home"
    for tool in "${local_tools[@]}"; do
        tool_path="$(command -v "$tool")" || {
            echo "$tool is not on PATH. Install it first." >&2
            return 1
        }
        printf '#!/bin/sh\nexec "%s" "$@"\n' "$tool_path" >"$sandbox_bin/$tool"
        chmod 755 "$sandbox_bin/$tool"
    done
    for tool in "${remote_tools[@]}"; do
        printf '#!/bin/sh\necho "%s was called, but this test did not fake it." >&2\nexit 97\n' \
            "$tool" >"$sandbox_bin/$tool"
        chmod 755 "$sandbox_bin/$tool"
    done
    run_env=()
}

remove_sandbox() {
    if [[ -n "${run_pid:-}" ]]; then
        kill -TERM -- "-$run_pid" 2>/dev/null || true
        wait "$run_pid" 2>/dev/null || true
    fi
    remove_temp_paths
}

fake() {
    cat >"$sandbox_bin/$1"
    chmod 755 "$sandbox_bin/$1"
}

remove_tool() {
    rm -f -- "$sandbox_bin/$1"
}

stub() {
    mkdir -p "$(dirname -- "$sandbox_repo/$1")"
    cat >"$sandbox_repo/$1"
    chmod 755 "$sandbox_repo/$1"
}

write_file() {
    mkdir -p "$(dirname -- "$sandbox_repo/$1")"
    cat >"$sandbox_repo/$1"
}

copy_file() {
    mkdir -p "$(dirname -- "$sandbox_repo/$1")"
    cp -p "$tests_root/$1" "$sandbox_repo/$1"
}

sandbox_git() {
    env -i \
        GIT_AUTHOR_EMAIL="tester@example.com" \
        GIT_AUTHOR_NAME="Script Tester" \
        GIT_COMMITTER_EMAIL="tester@example.com" \
        GIT_COMMITTER_NAME="Script Tester" \
        GIT_CONFIG_GLOBAL=/dev/null \
        GIT_CONFIG_NOSYSTEM=1 \
        HOME="$sandbox/home" \
        PATH="$sandbox_bin:/usr/bin:/bin" \
        git -C "$sandbox_repo" "$@"
}

commit_repo() {
    sandbox_git init --quiet --initial-branch=main
    sandbox_git add --all
    sandbox_git commit --quiet --message "Test commit"
}

add_origin() {
    sandbox_git init --quiet --bare "$sandbox/origin.git"
    sandbox_git remote add origin "$sandbox/origin.git"
    sandbox_git push --quiet origin main
}

repo_command() {
    cd -- "$sandbox_repo"
    exec env -i \
        FAKE_LOGS="$sandbox_logs" \
        GIT_AUTHOR_EMAIL="tester@example.com" \
        GIT_AUTHOR_NAME="Script Tester" \
        GIT_COMMITTER_EMAIL="tester@example.com" \
        GIT_COMMITTER_NAME="Script Tester" \
        GIT_CONFIG_GLOBAL=/dev/null \
        GIT_CONFIG_NOSYSTEM=1 \
        HOME="$sandbox/home" \
        PATH="$sandbox_bin:/usr/bin:/bin" \
        TMPDIR="$sandbox/tmp" \
        ${run_env[@]+"${run_env[@]}"} \
        "$@"
}

run_in_repo() {
    run_status=0
    (repo_command "$@") >"$sandbox/stdout" 2>"$sandbox/stderr" </dev/null || run_status=$?
    run_stdout="$(cat "$sandbox/stdout")"
    run_stderr="$(cat "$sandbox/stderr")"
}

start_in_repo() {
    set -m
    (repo_command "$@") >"$sandbox/stdout" 2>"$sandbox/stderr" </dev/null &
    run_pid=$!
    set +m
}

finish_run() {
    run_status=0
    wait "$run_pid" || run_status=$?
    run_pid=""
    run_stdout="$(cat "$sandbox/stdout")"
    run_stderr="$(cat "$sandbox/stderr")"
}

signal_in_repo() {
    local signal="$1"
    shift
    start_in_repo "$@"
    wait_for_log temp-step-started
    kill -"$signal" -- "-$run_pid"
    finish_run
}

temp_step() {
    cat <<EOF
#!/usr/bin/env bash

set -euo pipefail

paths=("\$TMPDIR"/$1.*)
EOF
    cat <<'EOF'
[[ "${#paths[@]}" -eq 1 && -d "${paths[0]}" ]]
mkdir -p "${paths[0]}/cache"
echo "Read-only cache." >"${paths[0]}/cache/entry"
chmod -R a-w "${paths[0]}/cache"
if [[ "${FAKE_TEMP_STEP_WAIT:-}" == 1 ]]; then
    touch "$FAKE_LOGS/temp-step-started"
    sleep 30
fi
exit 37
EOF
}

wait_for_log() {
    local tries=0
    until [[ -f "$sandbox_logs/$1" ]]; do
        tries=$((tries + 1))
        if ((tries > 300)); then
            fail_test "The run never wrote the $1 log."
        fi
        sleep 0.1
    done
}

temp_entries() {
    ls -A "$sandbox/tmp"
}

log_of() {
    if [[ -f "$sandbox_logs/$1" ]]; then
        cat "$sandbox_logs/$1"
    fi
}

fail_test() {
    echo "  $1" >&2
    if [[ -n "${run_status:-}" ]]; then
        echo "  The last run exited with $run_status. Its stdout and stderr follow." >&2
        echo "${run_stdout:-}" >&2
        echo "${run_stderr:-}" >&2
    fi
    exit 1
}

assert_equal() {
    if [[ "$1" != "$2" ]]; then
        fail_test "$3 differs.
  expected
$1
  actual
$2"
    fi
}

assert_contains() {
    if [[ "$1" != *"$2"* ]]; then
        fail_test "$3 lacks the text below.
  wanted
$2
  actual
$1"
    fi
}

assert_not_contains() {
    if [[ "$1" == *"$2"* ]]; then
        fail_test "$3 holds text it must not hold.
  unwanted
$2"
    fi
}

assert_ends_with() {
    if [[ "$1" != *"$2" ]]; then
        fail_test "$3 does not end with the text below.
  wanted
$2
  actual
$1"
    fi
}

run_tests() {
    local name status failed=0 total=0
    while IFS= read -r name; do
        total=$((total + 1))
        # The subshell is a plain command. Inside a condition, bash would
        # ignore set -e and a failing step could not fail its test.
        # https://www.gnu.org/software/bash/manual/html_node/The-Set-Builtin.html
        set +e
        (
            set -euo pipefail
            trap remove_sandbox EXIT
            exit_on_signals
            create_sandbox
            "$name"
        )
        status=$?
        set -e
        if ((status == 0)); then
            echo "ok $name"
        else
            echo "not ok $name"
            failed=$((failed + 1))
        fi
    done < <(declare -F | sed -n 's/^declare -f \(test_.*\)$/\1/p')
    if ((total == 0)); then
        echo "$0 defines no tests." >&2
        return 1
    fi
    if ((failed > 0)); then
        echo "$failed of $total tests failed in $(basename -- "$0")." >&2
        return 1
    fi
    echo "$total tests passed in $(basename -- "$0")."
}
