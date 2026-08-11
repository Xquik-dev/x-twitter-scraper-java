# syntax=docker/dockerfile:1
FROM debian:bookworm-slim@sha256:abd67ffcfa541b485a3dff59865ab629aa048a6c613e639d36e7456b0b229241

RUN apt-get update && apt-get install -y --no-install-recommends \
  libxkbcommon0 \
  ca-certificates \
  ca-certificates-java \
  make \
  curl \
  git \
  openjdk-17-jdk-headless \
  unzip \
  libc++1 \
  vim \
  && apt-get clean autoclean \
  && rm -rf /var/lib/apt/lists/* \
  && useradd --create-home --shell /bin/bash vscode \
  && install -d -o vscode -g vscode /workspace

# Ensure UTF-8 encoding
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

WORKDIR /workspace

COPY --chown=vscode:vscode . /workspace

USER vscode

HEALTHCHECK NONE
