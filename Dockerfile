FROM openjdk:17
EXPOSE 8080
ADD target/report.jar report.jar
ENTRYPOINT ["java" ,"-jar","/report.jar"]