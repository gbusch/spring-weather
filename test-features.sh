#!/bin/bash
set -e

docker build --tag feature-test --file Dockerfile.test . &> /dev/null &&
docker run --rm -i \
  --net=host \
  -v /var/run/docker.sock:/var/run/docker.sock \
  -v $(which docker):/bin/docker \
  -v ${HOME}:${HOME} \
  -w $(pwd) \
  -e HOME \
  -e PYTHONPATH=$(pwd)/features/:$(pwd)/features/support/ \
  feature-test \
  behave \
  --format pretty \
  --tags=~@skip \
  --tags=~@manual \
  $*