FROM anapsix/alpine-java
LABEL maintainer="sravani.madireddy14@gmail.com"
COPY build/libs/gs-spring-boot-0.1.0.jar /home/gs-spring-boot-0.1.0.jar
CMD ["java","-jar","/home/gs-spring-boot-0.1.0.jar"]