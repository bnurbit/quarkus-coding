# Annotations
Top-level overview of all annotations used in the project (except lombok).

## Quarkus
- @ConfigProperties - loading of configuration properties
- @QuarkusTest - bootstrap app for testing in a different port, inject mock services
- @TestHTTPResource - directly inject the URL into the test
- @Mock


## Microprofile
From Eclipse, the aim is to optimize Enterprise Java for the microservices architecture
- @ConfigProperty
- @RegisterRestClient - allows Quarkus to know that the annotated interface is meant to be available for CDI injection as a REST Client
- @RestClient


## Javax
The javax prefix is used by the Java programming language for a package of standard Java extensions


#### Enterprise
- @ApplicationScoped
- @Observes


#### Injection
- @Inject


#### Webservices
- @GET, @POST, @PUT, @DELETE
- @Path
- @PathParam
- @HeaderParam
- @QueryParam
- @FormParam
- @Consumes - defines the expected content-type consumed by this request (parameters)
- @Produces - defines the expected content-type produced by this request (return type)


#### Validation
- @Valid
- @Min
- @NotBlank
- @Size


#### JSON
- @JsonbProperty

## Resteasy
- @PartType
- @MultipartForm

## JUnit
- @Test