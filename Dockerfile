# Etapa de build com Java 24 + Maven
FROM eclipse-temurin:24-jdk AS build

WORKDIR /app

# Copia os arquivos e instala dependências
COPY . .

# Instala o Maven
RUN apt-get update && apt-get install -y maven

# Compila o projeto
RUN mvn clean install

# Etapa final com imagem leve contendo apenas o JDK
FROM eclipse-temurin:24-jdk-alpine AS runtime

WORKDIR /app

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Copia o JAR gerado na etapa de build
COPY --from=build /app/target/synaptech-0.0.1-SNAPSHOT.jar app.jar

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
