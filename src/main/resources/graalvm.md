# GraalVM
https://www.graalvm.org/

GraalVM is a Java VM and JDK based on HotSpot/OpenJDK, implemented in Java, released in May 2019. 
It supports additional programming languages and execution modes, like ahead-of-time compilation of Java applications for fast startup and low memory footprint.
GraalVM is a high-performance runtime that provides significant improvements in application performance and efficiency which is ideal for microservices.

### Configuration
1. Unzip to C:\Program Files\GraalVM\graalvm-ce-java11-21.1.0
2. Run in command prompt:
    * setx /M GRAALVM_HOME "C:\Program Files\GraalVM\graalvm-ce-java11-21.1.0"
    * setx /M JAVA_HOME "C:\Program Files\GraalVM\graalvm-ce-java11-21.1.0"
    * setx /M PATH "%JAVA_HOME%\bin;%PATH%"
3. Check in command prompt:
   * java -version

