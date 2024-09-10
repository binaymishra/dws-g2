FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/app.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENV PORT 10101
ENTRYPOINT ["java","-server", "-Xmx300M", "-XX:+UseG1GC", "-jar", "app.jar", "--server.port=10101"]