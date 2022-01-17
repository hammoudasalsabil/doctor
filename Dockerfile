
FROM openjdk:11
ADD target/tassdoc-0.0.1-SNAPSHOT.jar tassdoc-0.0.1-SNAPSHOT.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","tassdoc-0.0.1-SNAPSHOT.jar"]