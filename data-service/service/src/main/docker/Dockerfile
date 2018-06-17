FROM java:8-jre-alpine
MAINTAINER Adidas

ADD data-service-service.jar /app/
ENV JAVA_OPTS ""
#CMD ["java", "-Xmx200m", "-jar", "/app/data-service-service.jar"]
ENTRYPOINT java $JAVA_OPTS -jar /app/data-service-service.jar

#EXPOSE 8002