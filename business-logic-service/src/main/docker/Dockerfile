FROM java:8-jre-alpine
MAINTAINER Adidas

ADD business-logic-service.jar /app/
ENV JAVA_OPTS ""
#CMD ["java", "-Xmx200m", "-jar", "/app/business-logic-service.jar"]
ENTRYPOINT java $JAVA_OPTS -jar /app/business-logic-service.jar
#EXPOSE 8003