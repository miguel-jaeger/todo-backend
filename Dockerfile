# ---------- Build Stage ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar todo el proyecto (NO uses "app")
COPY . .

# Construir el proyecto
RUN mvn -X -e -DskipTests package


# ---------- Run Stage ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Crear carpeta para SQLite
RUN mkdir -p /app/data

# Copia el JAR del build
COPY --from=build /app/target/*.jar app.jar

# Comando de arranque
CMD ["sh","-c","java -Dserver.port=${PORT:-4002} -jar /app/app.jar"]
