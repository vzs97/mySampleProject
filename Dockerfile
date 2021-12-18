FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY "dependency/*" "app.jar"
ENTRYPOINT ["java","-jar","/app.jar","-Dspring.profiles.active=production","com.vzs.mysampleproject.MySampleProjectApplication"]