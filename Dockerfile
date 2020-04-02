FROM adoptopenjdk/maven-openjdk8 as development

WORKDIR /work
ADD pom.xml /work/
RUN mvn dependency:resolve-plugins dependency:go-offline

ADD src /work/src
RUN mvn -q package --quiet

FROM openjdk:8-jdk-alpine as deployment
WORKDIR /
COPY --from=development /work/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]