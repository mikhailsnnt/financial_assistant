# build
FROM maven AS build
VOLUME /root/.m2
COPY . .
RUN mvn install

# package
FROM openjdk:17-jdk-alpine AS run
ENTRYPOINT ["java","-jar","target/spring-cloud-eureka.jar"]