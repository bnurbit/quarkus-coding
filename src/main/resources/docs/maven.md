# Maven
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
- quarkus-junit5 - general testing
- rest-assured - rest endpoints testing

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

### Other dependencies
- lombok - generate boilerplate code
- quarkus-resteasy-jsonb / quarkus-resteasy-jackson - RESTEasy JSON serialization extensions. When added, Quarkus will use the application/json media type by default (can be overridden)
- quarkus-hibernate-validator - validation of input/output of REST services or parameters and return values of methods in the business services
- quarkus-rest-client - using of RESTEasy REST Client in order to interact with REST APIs


