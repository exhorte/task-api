FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copier le JAR dans le conteneur
COPY target/task-api-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port 8085
EXPOSE 8085

# Commande de démarrage
ENTRYPOINT ["java", "-jar", "app.jar"]