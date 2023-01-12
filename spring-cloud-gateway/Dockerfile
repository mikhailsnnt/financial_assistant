FROM maven AS build
VOLUME /root/.m2
COPY . .
RUN mvn install

FROM openjdk:17-jdk-alpine AS run
COPY --from=build ./target/spring-cloud-gateway.jar /spring-cloud-gateway.jar
ENTRYPOINT ["java","-jar","./target/spring-cloud-gateway.jar"]