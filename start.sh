#!/bin/bash
set -e

mkdir -p test-tmp/backend/config

COMPOSE_DOCKER_CLI_BUILD=1 docker-compose -f docker-compose.yml -f docker-compose-logging.yml up "$@"
