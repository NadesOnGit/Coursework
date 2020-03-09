# Use the latest MySQL image
FROM mysql
# Set the working directory
WORKDIR /tmp
# Copy all the files to the working directory of the container
COPY db/test_db/*.sql /tmp

# Copy the main SQL file to docker-entrypoint-initdb.d.
# Scripts and SQL files in this folder are executed on container startup.
# This is specific to MySQL.
COPY db/test_db/world.sql /docker-entrypoint-initdb.d
# Set the root password
ENV MYSQL_ROOT_PASSWORD example

FROM openjdk:latest
COPY ./target/Coursework-0.1.0.1-jar-with-dependencies.jar /tmp
ENTRYPOINT ["java", "-jar", "Coursework-0.1.0.1-jar-with-dependencies.jar"]