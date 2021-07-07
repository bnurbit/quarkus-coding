package pt.bnurbit.coding.quarkus;

import pt.bnurbit.coding.quarkus.services.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/hello")
public class GreetingResource {

    @Inject
    private GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") String name) {
        return greetingService.hello(name);
    }

    @GET
    @Path("/config")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.hello();
    }

    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello " + UUID.randomUUID();
    }

    @GET
    @Path("/html/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String get(@PathParam("id") String id) {
        return "<b>Hello " + id + "</b>";
    }

    @POST
    @Path("/json/body")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String post(String body) {
        return body;
    }

    @POST
    @Path("/json/param")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String post(@HeaderParam("name") String hName, @QueryParam("name") String name) { // can have the same name
        return "{\"Param\": \"" + name + "\",\"Header\": \"" + hName + "\"}";
    }
}

