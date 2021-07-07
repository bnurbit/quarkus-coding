# Quarkus
https://quarkus.io/
https://www.udemy.com/course/quarkus-backend-development-java/

Quarkus is a Kubernetes Native Java framework tailored for OpenJDK HotSpot and GraalVM, crafted from best-of-breed Java libraries and standards. 
The goal of Quarkus is to make Java a leading platform in Kubernetes and serverless environments while offering developers a 
unified reactive and imperative programming model to optimally address a wider range of distributed application architectures.

# Configuration
* Install Quarkus Run Configs in Intellij

#Defining properties
- if no prefix, then it's general property for all profiles
- if prefix %<profile-name>. then properties are used for that profile only
- all configs: https://quarkus.io/guides/all-config
- not all properties refresh automatically, for instance, the datasource url

# Annotations
- ConfigProperties