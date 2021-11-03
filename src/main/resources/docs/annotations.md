# Annotations
Top-level overview of all annotations used in the project (except lombok).

## Quarkus
- arc
  - @ConfigProperties - loading of configuration properties
- test
  - @QuarkusTest - bootstrap app for testing in a different port, inject mock services
  - @TestHTTPResource - directly inject the URL into the test
  - @Mock
- vertx.web
  - @Route
  - @RouteBase
  - @RouteFilter

## Microprofile
From Eclipse, the aim is to optimize Enterprise Java for the microservices architecture.
- config
  - @ConfigProperty
- faulttolerance
  - @CircuitBreaker
  - @Fallback
  - @Retry
  - @Timeout
- openapi
  - @OpenApiDefinition
  - @Info
  - @Server
- rest.client
  - @RestClient 
  - @RegisterRestClient - allows Quarkus to know that the annotated interface is meant to be available for CDI injection as a REST Client
  
## Javax
The javax prefix is used by the Java programming language for a package of standard Java extensions.
- enterprise.context
  - @ApplicationScoped
- enterprise.event
  - @Observes
- inject
  - @Inject
- json.bind
  - @JsonbProperty
- validation.constraints
  - @Valid
  - @Min
  - @NotBlank
  - @Size
- ws.rs
  - @GET, @POST, @PUT, @DELETE
  - @Path
  - @PathParam
  - @HeaderParam
  - @QueryParam
  - @FormParam
  - @Consumes - defines the expected content-type consumed by this request (parameters)
  - @Produces - defines the expected content-type produced by this request (return type)
- websocket
  - @ServerEndpoint
  - @PathParam
  - @OnClose, @OnError, @OnMessage, @onOpen
  
## Resteasy
- @PartType
- @MultipartForm

## JUnit
- @Test