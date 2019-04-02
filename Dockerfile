FROM java:8

ADD /root/aicallsystem/build/libs/acs-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT java -jar app.jar
