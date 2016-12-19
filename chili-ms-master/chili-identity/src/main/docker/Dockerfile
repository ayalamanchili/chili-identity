FROM java:8
VOLUME /tmp
EXPOSE 2222
ADD chili-identity-1.0-SNAPSHOT.jar chili-identity.jar
RUN bash -c 'touch /chili-identity.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/chili-identity.jar"]