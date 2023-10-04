FROM openjdk
COPY target/my-app-0.1.jar /my-app-0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/my-app-0.1.jar"]
