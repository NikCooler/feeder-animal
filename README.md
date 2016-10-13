# Eat and Go

Eat & Go server

## First setup (Step by step)

#### 1. Download MySQL server and configure it

#### 2. Clone Github project:

<https://github.com/NikCooler/feeder-animal>

#### 3. Configure 'liquibase.properties'

This file for configure connection to DB.
```
url: CHANGE IT
login: CHANGE IT
password: CHANGE IT
```
- Execute `mvn liquibase:update` in package `liquibase`

Do not commit this file - 'liquibase.properties'.

#### 4. Build project

```
mvn clean install
```

#### 5. Program arguments

```
--spring.config.name=application
--spring.config.location={PATH_TO_YOUR_CONFIG_FOLDER}
```

For example: `file:/C:/work/eat&go/`

#### 6. Run application

```
mvn spring-boot:run -Drun.arguments="--spring.config.name=..,--spring.config.location=.."
```

For example:
```
mvn spring-boot:run -Drun.arguments="--spring.config.name=application,--spring.config.location=file:/C:/work/eat&go/"
```



