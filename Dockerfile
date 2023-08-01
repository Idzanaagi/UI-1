FROM maven:3.9.3-amazoncorretto-20-debian-bookworm
WORKDIR /tests
COPY ./src /tests/src
COPY ./pom.xml /tests/pom.xml
RUN mvn dependency:go-offline
RUN apt-get update && \
    apt-get install -y wget && \
    cd ../opt/ && \
    wget https://github.com/allure-framework/allure2/releases/download/2.23.1/allure-2.23.1.zip && \
    apt-get install unzip -y && \
    unzip allure-2.23.1.zip && \
    rm allure-2.23.1.zip
CMD mvn clean test;/opt/allure-2.23.1/bin/allure generate --clean allure-results
