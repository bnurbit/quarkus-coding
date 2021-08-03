package pt.bnurbit.coding.quarkus.multipart;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Test method creates a multipart body and calls the rest client to send the file
// Automatically figures out that it is a multipart form
// Calls the other method under the same path to return the body
@RegisterRestClient(configKey = "config.multipart")
@Path("/multipart")
public interface MultipartService {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    String sendFile(@MultipartForm MultipartBody body);

}
