#This is a simple docker Spring Boot app

##How to run


$ ./gradlew build buildDocker


docker run -p 8080:8080 -t au.com.jiangren/spring-boot-microservice:1.0-SNAPSHOT
