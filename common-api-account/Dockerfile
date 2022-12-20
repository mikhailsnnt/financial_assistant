# build
FROM maven AS build
VOLUME /root/.m2
COPY . .
RUN mvn install

# package without maven
FROM openjdk:17-jdk-alpine AS run
COPY --from=build ./target/common-api-account.jar /common-api-account.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/common-api-account.jar"]