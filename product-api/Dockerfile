FROM maven:3.2.3-jdk-17
WORKDIR .
RUN mvn clean install
COPY . .
EXPOSE 8081
CMD ["mvn", "spring-boot:run"]