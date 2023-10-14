

# Estágio de construção
FROM maven:3.0.11-openjdk-17 as builder

# Configuração do ambiente e cópia do código-fonte
WORKDIR /todolist
COPY . .

# Construa seu projeto Maven
RUN mvn clean install

# Estágio de tempo de execução
FROM openjdk:17-jdk-slim as runtime

# Copie o JAR do estágio de construção para o estágio de tempo de execução
COPY --from=builder /todolist/target/todolist-1.0.0.jar /app.jar

# Configure a porta para exposição
EXPOSE 8080

# Comando de entrada
CMD ["java", "-jar", "/app.jar"]