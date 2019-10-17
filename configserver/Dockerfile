FROM openjdk:11
ADD ./target/configserver-0.0.1-SNAPSHOT.jar /usr/src/configserver-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "configserver-0.0.1-SNAPSHOT.jar"]