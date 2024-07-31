FROM openjdk:17 AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean package

FROM openjdk:17
COPY --from=build /app/target/colvir-k8s*.jar /usr/local/lib/colvir-k8s.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/colvir-k8s.jar"]