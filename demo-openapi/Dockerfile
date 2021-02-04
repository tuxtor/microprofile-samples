FROM bellsoft/liberica-openjdk-alpine:11

RUN mkdir /app
WORKDIR /app
ADD ./target/demo-openapi-1.0.0.jar /app

EXPOSE 8080
CMD ["java", "-jar", "demo-openapi-1.0.0.jar"]