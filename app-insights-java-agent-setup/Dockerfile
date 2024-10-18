# Prerequisites:
# 1. Shared volume mounted to /java-agent in both init-container and app container
# 2. Environment variable CONNECTION_STRING in init container set to the Application Insights connection string

FROM mcr.microsoft.com/cbl-mariner/base/core:2.0

ARG version="3.5.4"

RUN tdnf update -y && tdnf install -y curl ca-certificates

RUN curl -L "https://github.com/microsoft/ApplicationInsights-Java/releases/download/${version}/applicationinsights-agent-${version}.jar" > agent.jar

ADD setup.sh /setup.sh

ENTRYPOINT ["/bin/sh", "setup.sh"]
