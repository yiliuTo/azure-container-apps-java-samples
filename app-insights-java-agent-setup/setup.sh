#!/bin/sh

if [[ -z "$CONNECTION_STRING" ]]; then
  echo "Environment variable CONNECTION_STRING is not found. Exiting..."
  exit 1
else
  echo "{\"connectionString\": \"$CONNECTION_STRING\"}" > /java-agent/applicationinsights.json
  cp agent.jar /java-agent/agent.jar
fi
