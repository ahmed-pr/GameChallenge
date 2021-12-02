FROM openjdk:11
WORKDIR /usr
COPY Games-0.0.1-SNAPSHOT.jar Games-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","Games-0.0.1-SNAPSHOT.jar"]