package pt.bnurbit.coding.quarkus;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(title = "Getting started API", description = "test API description", version = "1.1"),
        servers = @Server(url = "some_url")
)
public class OpenAPIConfiguration extends Application {
}
