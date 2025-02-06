ARG REGISTRY
###Builder Image###
FROM ${REGISTRY}/yomadevops/maven:3.6.3-jdk-11-alpine as builder

ARG JFROG_URL
ARG JFROG_USER
ARG JFROG_PASS
ARG JFROG_BUILDNO
ARG PRJ_NAME
ARG JFROG_CLI_EXTRACTORS_REMOTE

COPY . /opt/app/
WORKDIR /opt/app/

RUN jf c add yoma --artifactory-url=${JFROG_URL}/artifactory --user=${JFROG_USER} --password=${JFROG_PASS} --interactive=false
RUN jf mvnc --server-id-resolve yoma --server-id-deploy yoma --repo-resolve-releases libs-release --repo-resolve-snapshots libs-snapshot --repo-deploy-releases libs-release-local  --repo-deploy-snapshots libs-snapshot-local
RUN jf c show
RUN jf mvn clean install --build-name=gitlabci-maven-artifactory --build-number=${JFROG_BUILDNO}
RUN jf rt bce gitlabci-maven-artifactory ${JFROG_BUILDNO}
RUN jf rt bp gitlabci-maven-artifactory ${JFROG_BUILDNO}

RUN mv ${PRJ_NAME}target/*.jar app.jar

###Executable Image###
FROM ${REGISTRY}/yoma/openjdk:11-alpine
COPY --from=builder /opt/app/app.jar .
VOLUME /config
