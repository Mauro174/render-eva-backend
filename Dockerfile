# ===== ETAPA 1: Construir el JAR =====
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar archivos necesarios
COPY pom.xml .
COPY src ./src

# Compilar el proyecto (sin tests)
RUN mvn -q -DskipTests package

# ===== ETAPA 2: Imagen final ligera =====
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiar el JAR compilado desde la etapa 1
COPY --from=build /app/target/*.jar app.jar

# Render usa la variable PORT para el puerto
ENV PORT=8080
EXPOSE 8080

# Ejecutar Spring Boot
ENTRYPOINT ["java","-jar","app.jar"]
