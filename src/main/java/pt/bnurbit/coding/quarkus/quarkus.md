# Quarkus
https://www.udemy.com/course/quarkus-backend-development-java/

Install Quarkus Run Configs in Intellij

Speed-up server starting time - native

Installed features:
- cdi - contexts and dependency injection
- resteasy

Profile dev - live coding activated
- Quarkus loads everything that was changed on demand

Dependencies:
- quarkus-arc       https://quarkus.io/blog/quarkus-dependency-injection/
- quarkus-resteasy
- quarkus-junit5    general testing 
- rest-assured      rest endpoints testing

Defining properties
- if no prefix, then it's general property for all profiles
- if prefix %<profile-name>. then properties are used for that profile only
- all configs: https://quarkus.io/guides/all-config
- not all properties refresh automatically, for instance, the datasource url


