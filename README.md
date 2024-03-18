# backend-java-test

Projectos creados con el IDE IntelliJ IDE 2023.3.4 (Community Edition)

- rest: proyecto principal
- restSecond: proyecto secundario con el servicio _'[http://localhost:8090/api/hola](http://localhost:8090/api/hola)'_

Archivos jar para ejecutar carpeta _'jars'_

- rest-0.0.1-SNAPSHOT.jar
- restSecond-0.0.1-SNAPSHOT.jar

Documentación basica con Swagger [http://localhost:8090/swagger-ui/index.html#/](http://localhost:8090/swagger-ui/index.html#/)

![swagger](./docs/swagger.png)

## Coneción a Base de datos

- h2: Base de datos en memoria
- uso de JPA _spring-boot-starter-data-jpa_

## Version de Spring Boot 3.2.3

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.3</version>
    <relativePath/>
</parent>
```
