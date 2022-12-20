# build
FROM maven
VOLUME /root/.m2
COPY . .
RUN mvn install

# package without maven
FROM openjdk:17-jdk-alpine
EXPOSE 8080
ENTRYPOINT ["java","-jar","/common-api-account.jar"]