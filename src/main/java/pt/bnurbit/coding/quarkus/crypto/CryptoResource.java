package pt.bnurbit.coding.quarkus.crypto;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.concurrent.CompletionStage;

@Path("/crypto")
public class CryptoResource {

    @Inject
    @RestClient
    private CryptoService cryptoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<Collection<Currency>> getCrypto(@QueryParam("id") String id){
        return cryptoService.getCurrency(id);
    }
}
