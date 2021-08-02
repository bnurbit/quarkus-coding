package pt.bnurbit.coding.quarkus.greeting;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class GreetingService {

    @Inject
    private GreetingConfig greetingConfig;

    @ConfigProperty(name = "greeting.name")   // error if the property is not defined
    private String name;

    @ConfigProperty(name = "greeting.suffix", defaultValue = "english")
    private String suffix;

    @ConfigProperty(name = "greeting.prefix") // no error if the property is not defined
    private Optional<String> prefix;

    @ConfigProperty(name = "greeting.base64name") // encoded name
    private Base64Value base64Name;

    public String hello() {
        log.debug("Saying hello to random user");

        //final String name = ConfigProvider.getConfig().getValue("greeting.name", String.class); // another way of accessing config properties
        return greetingConfig.getPrefix().orElse("null")
                + "-" + greetingConfig.getName()
                + "-" + greetingConfig.getSuffix()
                + "-country-" + greetingConfig.getCountry().getName()
                + ":" + greetingConfig.getCountry().getId();
    }

    public String hello(String name) {
        return String.format("Hello %s, your id is %s", name, UUID.randomUUID());
    }
}
