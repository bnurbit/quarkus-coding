# Project lombok

Goal: plugging into the build process and auto-generating Java bytecode into the .class files based on project annotations.
Pure build dependency, not runtime.
Delombok tool can be used to rollback lombok changes by generating the source code

### Core Java, Encapsulation and DTOs
Data Transfer Objects: data type with the sole purpose of representing complex values, usually immutable

- @Getter
    - class level: generate for all fields of the class
    - field level: can be used to restrict access level, lazy loading
- @Setter
    - class level: generate for all fields of the class
    - field level: can be used to restrict access level, lazy loading
- @Accessors
    - class level: customize getters and setters by removing de get/set from the naming (fluent) or allowing chain calls
- @NoArgsConstructor
    - class level: generate empty constructor
- @AllArgsConstructor
    - class level: generate constructor for all fields
- @RequiredArgsConstructor
    - class level: generate constructor for all final fields
- @NonNull
    - field level: check for nullability in the setter (non-final) or constructor(final) and can throw NPE
- @ToString
    - class level: generate toString() method including all class attributes. Can exclude and set specific("of") parameters or call super
- @EqualsAndHashCode
    - class level: generate equals() and hashCode() methods by default including all non-final properties. Should be avoided for JPA entities
- @Data
    - class level: shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter on all non-final fields and @RequiredArgsConstructor
- @Value
    - class level: immutable version of @Data. All fields are private and final by default. The class is also final
  
### Builder Pattern
Very useful for immutable classes (like configuration classes)

- @Builder
  - class level: generate the builder pattern, without the need of writing an extra Builder class
  
### Checked Exceptions
Java APIs are often designed to throw a number of checked exceptions, forcing the client to either catch or declare throws

- @SneakyThrows
    - method level: avoid catching checked exceptions when we know they cannot happen
  
### Resource releasing
- @Cleanup
    - local variable level: force the release of any resources (no need for them to implement AutoCloseable)
  
### Logging
- @Slf4j/@Log/@CommonsLog/@Log4j/@Log4j2/@XSlf4j
    - class level: provides an instance of a logger from the chosen framework
  
### Thread-Safety
Java synchronized keyword might not be a 100% safe approach, leading to unexpected deadlocks

- @Synchronized
    - method level: generates a private, unexposed field that will be used for locking