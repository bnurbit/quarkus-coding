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
- mvn package
- produces several outputs in /target
- /target/<app>-<app-version>-SNAPSHOT.jar -> not a runnable jar. the regular artifact produced by maven that contains just the classes and resources
- /target/quarkus-app/quarkus-run.jar -> runnable jar. not a fat jar (dependencies are copied into subdirectories of quarkus-app/lib/)
- /target/config -> application.properties should go here

### Running Jar
- java -jar <jar-name>.jar

### Logging
- quarkus.log.level - By default is INFO
- quarkus.log.category."<package-name>".level - Set level for a particular package
- quarkus.log.console.enable - Enable/Disable logging to the console
- quarkus.log.console.color - Enable/Disable colors in the console
- quarkus.log.console.format - Specify logging format: https://quarkus.io/guides/logging
- quarkus.log.file.enable - Enable/Disable logging to a file
- quarkus.log.file.path - Specify the logging file path, default is ./quarkus.log (target folder)
- quarkus.log.console.json - Enable/Disable logging in json format, requires io.quarkus quarkus-logging-json dependency. Useful to use with a searching engine (like ElasticSearch)