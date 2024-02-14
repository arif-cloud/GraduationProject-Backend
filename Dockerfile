FROM openjdk:21
LABEL maintainer="javaguides.net"
ADD target/ArticleApi-0.0.1-SNAPSHOT.jar ArticleApi-jar
ENTRYPOINT ["java", "-jar", "ArticleApi-jar"]