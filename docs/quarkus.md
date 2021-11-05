# Quarkus
- https://quarkus.io/
- https://www.udemy.com/course/quarkus-backend-development-java/

Quarkus is a Kubernetes Native Java framework tailored for OpenJDK HotSpot and GraalVM, crafted from best-of-breed Java libraries and standards. 
The goal of Quarkus is to make Java a leading platform in Kubernetes and serverless environments while offering developers a 
unified reactive and imperative programming model to optimally address a wider range of distributed application architectures.

### Configuration
* Install Quarkus Run Configs in Intellij

### Profiles
By default: dev, prod, test

### Defining properties
- if no prefix, then it's general property for all profiles
- if prefix %<profile-name>. then properties are used for that profile only
- all configs: https://quarkus.io/guides/all-config
- not all properties refresh automatically, for instance, the datasource url
- quarkus can cache some properties, running clean will properly refresh the properties

### Packaging
- mvn package / gradle build
- produces several outputs in /target
- /target/<app>-<app-version>-SNAPSHOT.jar -> not a runnable jar. the regular artifact produced by maven that contains just the classes and resources
- /target/quarkus-app/quarkus-run.jar -> runnable jar. not a fat jar (dependencies are copied into subdirectories of quarkus-app/lib/)
- /target/config -> application.properties should go here

### Running Jar
- java -jar <jar-name>.jar

### Datasources
- projects that use data often require connections to relational databases
- 2 options to obtain a connection:
    - use a datasource and configure a JDBC driver (quarkus-agroal)
    - reactive drivers (vert.x reactive library)
- Quarkus zero config database setup for dev mode (might require Docker)
    - no configuration needed (url, username, password)
    - container: Postgresql, MySql, MariaDB
    - container with license agreement: DB2, MSSQL
    - in-process: H2, Apache Derby
- Configuration
    - quarkus.datasource.db-kind= (optional if there is only 1 extension)
    - quarkus.datasource.username=
    - quarkus.datasource.password=
    - quarkus.datasource.jdbc.url=
    - quarkus.datasource.jdbc.max-size=
    - quarkus.datasource.reactive.url=
    - quarkus.datasource.reactive.max-size=
- By default, including both JDBC extension (+ Agroal) and a reactive datasource extension both will be created
    - quarkus.datasource.jdbc=false
    - quarkus.datasource.reactive=false
- Multiple datasources
    - quarkus.datasource.db-kind=h2
    - quarkus.datasource.users.db-kind=h2
    - quarkus.datasource.inventory.db-kind=h2
- Datasource Health Check
    - quarkus-smallrye-health extension automatically adds a readiness health check to validate the datasource
    - access /q/health/ready endpoint
    - property quarkus.datasource.health.enabled
- Datasource Metrics
    - quarkus-micrometer or quarkus-smallrye-metrics extension expose some datasource metrics
    - access /q/metrics endpoint
    - property quarkus.datasource.metrics.enabled
    


