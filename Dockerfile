
FROM openjdk:11
ADD target/tassdoc.jar tassdoc.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","tassdoc.jar"]