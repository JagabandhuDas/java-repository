FROM java:8
VOLUME /tmp
ADD target/SpringBootSecurity-0.0.1-SNAPSHOT.jar springboot.jar
RUN bash -c 'touch /springboot.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /springboot.jar","-Dspring.profiles.active=container"]
