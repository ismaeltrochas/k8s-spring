FROM openjdk:17-alpine3.14

WORKDIR /app

COPY target/kubetest*-SNAPSHOT.jar /app

EXPOSE 8080

ENV MONGO_HOST=mongodb
ENV MONGO_PORT=27017
ENV MONGO_DB=orquestador
ENV MONGO_USER=root
ENV MONGO_PASSWORD=secret

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

HEALTHCHECK --interval=30s --timeout=3s \
  CMD wget -q --spider http://localhost:8080/actuator/health || exit 1

CMD ["java", "-jar", "kubetest-0.0.1-SNAPSHOT.jar"]