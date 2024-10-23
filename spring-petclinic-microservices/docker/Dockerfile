FROM eclipse-temurin:17 as builder
WORKDIR application
ARG ARTIFACT_NAME
COPY ../spring-petclinic-microservices/${ARTIFACT_NAME}/target/${ARTIFACT_NAME}-*.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract


FROM eclipse-temurin:17
WORKDIR application

ARG EXPOSED_PORT
RUN if [ -n "${EXPOSED_PORT}" ]; then \
      echo "EXPOSE ${EXPOSED_PORT}" >> Dockerfile; \
    fi

COPY --from=builder application/dependencies/ ./

# fix for https://stackoverflow.com/questions/51115856/docker-failed-to-export-image-failed-to-create-image-failed-to-get-layer
# (only last copy caused issue)
# this seems to be triggered by using btrfs:
# https://github.com/moby/moby/issues/36573
RUN true
COPY --from=builder application/spring-boot-loader/ ./
RUN true
COPY --from=builder application/snapshot-dependencies/ ./
RUN true
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
