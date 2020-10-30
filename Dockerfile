FROM frolvlad/alpine-oraclejre8:cleaned
MAINTAINER dyronrh
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","/app.jar"]


