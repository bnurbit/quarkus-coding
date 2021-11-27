# Dependency Management (Maven)
https://maven.apache.org/

Maven is a powerful project management tool that is based on POM (project object model). 
It is used for projects build, dependency and documentation.

### Configuration
1. Download binary zip instead of source zip
1. Unzip to C:\Program Files\Maven\apache-maven-3.8.1
1. Run in command prompt:
    * setx /M MAVEN_HOME "C:\Program Files\Maven\apache-maven-3.8.1"
    * setx /M PATH "%MAVEN_HOME%\bin;%PATH%"
1. Check in command prompt:
   * mvn -version
   
### Create Quarkus project with maven plugin
mvn io.quarkus:quarkus-maven-plugin:1.3.1.Final:create \
-DprojectGroupId=<package> \
-DprojectArtifactId=<project_name> \
-DclassName="<package>.<class_name>" \
-Dpath="/<endpoint_path>"

Installed features:
- cdi - contexts and dependency injection
- resteasy

Profile dev - live coding activated
- Quarkus loads everything that was changed on demand

Dependencies:
- quarkus-resteasy
- quarkus-junit5
- rest-assured

Plugins:
- quarkus-maven-plugin
- maven-compiler-plugin - used to compile the source code of a Maven project (compile, testCompile)
- maven-surefire-plugin - used during the test phase of the build lifecycle to execute the unit tests of an application

### mvnw and mvnw.cmd
These files are from Maven wrapper. It works similarly to the Gradle wrapper.
Allow to run the Maven project without having Maven installed and present on the path. 
It downloads the correct Maven version if it is not found.

### Running from Maven
- mvnw quarkus:dev -Dgreeting.name="Hello"

### Adding dependencies
- mvnw quarkus:add-extension -Dextensions="<extension_name>"

### Other dependencies
- io.quarkus
  - quarkus-resteasy
  - quarkus-logging-json
  - quarkus-resteasy-jsonb / quarkus-resteasy-jackson - RESTEasy JSON serialization extensions. When added, Quarkus will use the application/json media type by default (can be overridden)
  - quarkus-hibernate-validator - validation of input/output of REST services or parameters and return values of methods in the business services
  - quarkus-rest-client - using of RESTEasy REST Client in order to interact with REST APIs
  - quarkus-undertow-websockets - 
  - quarkus-smallrye-openapi - 
  - quarkus-smallrye-fault-tolerance - 
  - quarkus-vertx-web (renamed to quarkus-reactive-routes) -
  - quarkus-agroal - light weight connection pool implementation designed for very high performance and scalability. Features integration with other Quarkus components (security, transaction management, health,  metrics)
  - quarkus-jdbc-h2 - jdbc driver for h2 database
  - quarkus-jdbc-mysql - jdbc driver for mysql database
  - quarkus-hibernate-orm - hibernate object–relational mapping
- org.jboss.resteasy.resteasy-multipart-provider -

### Test dependencies
- io.quarkus.quarkus-junit5 - general testing
- io.rest-assured.rest-assured - rest endpoints testing

### Maven vs Gradle
Gradle
- high performance
- groovy-based domain-specific language (DSL)
- preferred for Android applications
- more flexible (code writing, tasks with lifecycle)
Maven
- standardization
- extensible markup language (XML)
- compatible with other languages besides Java
