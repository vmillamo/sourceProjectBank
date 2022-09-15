FROM openjdk:17.0.2-oracle
COPY ./target/prjConfigService-0.0.1-SNAPSHOT.jar config-service.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","config-service.jar"]