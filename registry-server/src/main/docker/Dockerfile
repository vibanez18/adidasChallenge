FROM java:8-jre-alpine
MAINTAINER Adidas

ADD registry-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry-server.jar"]

EXPOSE 8761