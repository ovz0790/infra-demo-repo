# finance-api

# Tools
Java 8
Gradle 4.7
Spring Boot 2.0

# Build
Install gradle 4.7
add to Idea settings for gradle home, check it also for "Service directory path"
add to dir with gradle installation gradle.properties file with your nexus credentials:

quandooNexusUser=yourName
quandooNexusPassword=yourPassword

# Configuration
There some default configurations in application.yml
Custom configurations could be setted in external *.properties or *.yml files with command line attribute for app:
java -jar web-app-1.0-SNAPSHOT.jar -Dspring.config.location=<list of files or dir with them>