FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY ./target/school-manager-server.jar /app

COPY ./application-local.properties /application-local.properties

CMD ["java", "-jar", "school-manager-server.jar"]

EXPOSE 8080

