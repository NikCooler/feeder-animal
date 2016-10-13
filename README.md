# Eat and Go

Eat & Go server

## First setup (Step by step)

#### 1. Download and configure

- MySQL server 5
- Maven 3
- Java 8

Configure `M2_HOME` and `JAVA_HOME` variables.

#### 2. Clone Github project:

<https://github.com/NikCooler/feeder-animal>

#### 3. Configure `liquibase.properties`, `application.properties`

This file for configure connection to DB.
Create new file based on `liquibase.properties.example` with name `liquibase.properties` and place it in the same folder.

- Change next parameters in `liquibase.properties`:
```
url: CHANGE IT
login: CHANGE IT
password: CHANGE IT
```

Create new file based on `application.properties.example` with name `liquibase.properties` and place it in the same folder.
- Change next parameters in `application.properties`:
```
spring.datasource.url = CHANGE IT!
spring.datasource.username = CHANGE IT!
spring.datasource.password = CHANGE IT!
```

#### 4. Build project

Execute next command:

```
mvn clean install
```

#### 5. Run project

- If you use Intellij Idea:

Run method `main` from class `com.eat.go.EatAndGoApp`


- If you use command line:

Run application

```
mvn spring-boot:run -Drun.arguments="--spring.config.name=..,--spring.config.location=.."
```

For example:
```
mvn spring-boot:run -Drun.arguments="--spring.config.name=application,--spring.config.location=file:/C:/work/eat&go/"
```

#### 6. Try to go on http://localhost:8084/swagger-ui.html


