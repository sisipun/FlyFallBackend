FROM openjdk:8
ADD . /src
WORKDIR /src
RUN ./gradlew build -x test
COPY ./build/libs/* ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "./app.jar"]
