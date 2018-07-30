
FROM openjdk:8-jre-alpine
ADD target/ /opt/
WORKDIR /opt
EXPOSE 8081
ENTRYPOINT exec java -Xms128m -Xmx128m -XX:MaxMetaspaceSize=128m $JAVA_OPTS -jar java-bean-validation.jar
