## Build and Install without tests
mvn clean install -DskipTests=true

## Run tests
mvn test -pl lab-seq-api -am

## Run
mvn spring-boot:run

## Swagger
http://localhost:8082/swagger-ui/index.htm

## Example of URL endpoint (Method GET)
http://localhost:8082/altice/labseq/10


