# build
FROM maven AS build
VOLUME /root/.m2
COPY . .
RUN mvn install

# package
FROM openjdk:17-jdk-alpine AS run
COPY --from=build ./target/spring-cloud-eureka.jar /spring-cloud-eureka.jar
ENTRYPOINT ["java","-jar","/spring-cloud-eureka.jar"]