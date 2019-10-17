FROM openjdk:11
ADD ./target/serviceregistry-0.0.1-SNAPSHOT.jar /usr/src/serviceregistry-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "serviceregistry-0.0.1-SNAPSHOT.jar"]