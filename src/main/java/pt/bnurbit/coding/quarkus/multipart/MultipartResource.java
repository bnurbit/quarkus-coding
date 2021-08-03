package pt.bnurbit.coding.quarkus.multipart;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;

@Path("/multipart")
public class MultipartResource {

    @Inject
    @RestClient
    private MultipartService multipartService;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String echoFile(String body) {
        return body;
    }

    @POST
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String callEcho() {
        final MultipartBody multipartBody = new MultipartBody(new ByteArrayInputStream("Hello World!".getBytes()), "hello.txt");
        return multipartService.sendFile(multipartBody);
    }
}
