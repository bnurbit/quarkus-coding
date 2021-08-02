package pt.bnurbit.coding.quarkus.crypto;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.concurrent.CompletionStage;

// Register rest client. Providing a config key simplifies the url and scope property definition.
// This should mirror the actual resource
@RegisterRestClient(configKey = "config.crypto")
@Path("/ticker")
public interface CryptoService {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<Collection<Currency>> getCurrency(@QueryParam("id") String id);
}
