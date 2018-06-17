FROM java:8-jre-alpine
MAINTAINER Adidas

ADD data-service-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/data-service-service.jar"]

EXPOSE 8002