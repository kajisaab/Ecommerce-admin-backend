FROM openjdk:17
WORKDIR /opt
ENV PORT 8080
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
