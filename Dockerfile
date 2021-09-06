FROM adoptopenjdk:16-jre-hotspot
WORKDIR /opt/app
COPY target/sv2021-jvjbf-kepesitovizsga-0.0.1-SNAPSHOT.jar sv2021-jvjbf-kepesitovizsga
CMD ["java", "-jar", "sv2021-jvjbf-kepesitovizsga"]