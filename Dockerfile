FROM maven:3.9.6-eclipse-temurin-17-alpine

RUN adduser -D aluno
USER aluno

EXPOSE 8080

WORKDIR /sprint1

COPY . .

RUN mvn clean install

RUN cp target/*.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]
