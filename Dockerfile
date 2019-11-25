FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/hotels-cvc-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} hotels-cvc-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/hotels-cvc-0.0.1-SNAPSHOT.jar"]
