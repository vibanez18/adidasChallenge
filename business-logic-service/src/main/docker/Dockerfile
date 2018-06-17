FROM java:8-jre-alpine
MAINTAINER Adidas

ADD business-logic-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/business-logic-service.jar"]

EXPOSE 8003