FROM openjdk:16
LABEL maintainer ="blogpost.net"
ADD target/Blogpost-0.0.1-SNAPSHOT.jar Blogpost.jar

ENTRYPOINT ["java","jar","blog.jar"]