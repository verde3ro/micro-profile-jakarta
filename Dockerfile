# =========================
# Etapa 1: Build con Maven
# =========================
FROM registry.redhat.io/ubi9/openjdk-21-runtime:1.24 AS builder

USER root

# Instalar Maven
RUN microdnf install -y maven && microdnf clean all

WORKDIR /app

# Copiar proyecto
COPY pom.xml .
COPY src ./src
COPY extra-content ./extra-content

# Construir bootable jar
RUN mvn clean package -DskipTests

# =========================
# Etapa 2: Runtime
# =========================
FROM registry.access.redhat.com/ubi9/openjdk-21-runtime:1.24

WORKDIR /app

# Copiar jar generado
COPY --from=builder /app/target/micro-profile-jakarta-bootable.jar app.jar

# Puertos
EXPOSE 8080 9990

# Ejecutar app
ENV JAVA_OPTS="-Djboss.bind.address=0.0.0.0 -Djboss.bind.address.management=0.0.0.0 -Djboss.server.log.dir=logs"
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
