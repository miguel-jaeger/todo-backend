FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
RUN mkdir -p /app/data

# Copiar todo el código fuente del proyecto
COPY app ./ 

# Construir proyecto
RUN mvn -B -DskipTests=true clean package

FROM eclipse-temurin:21-jre
WORKDIR /app
RUN mkdir -p /app/data

# Copiar el archivo jar compilado
COPY --from=build /app/target/*.jar app.jar

# Copiar archivo de base de datos SQLite al contenedor
COPY /app/modelo.db /app/data/modelo.db

CMD ["sh","-c","mkdir -p /app/data && java -Dserver.port=${PORT:-4002} -jar /app/app.jar"]
