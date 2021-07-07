package pt.bnurbit.coding.quarkus.services;

import pt.bnurbit.coding.quarkus.config.GreetingConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class GreetingService {

    @Inject
    private GreetingConfig greetingConfig;

//    @ConfigProperty(name = "greeting.name")   // error if the property is not defined
//    private String name;
//
//    @ConfigProperty(name = "greeting.suffix", defaultValue = "english")
//    private String suffix;
//
//    @ConfigProperty(name = "greeting.prefix") // no error if the property is not defined
//    private Optional<String> prefix;

    public String hello(){
        //final String name = ConfigProvider.getConfig().getValue("greeting.name", String.class); // another way of accessing config properties
        return greetingConfig.getPrefix().orElse("null")
                + "-" + greetingConfig.getName()
                + "-" + greetingConfig.getSuffix()
                + "-country-" + greetingConfig.getCountry().getName()
                + ":" + greetingConfig.getCountry().getId();
    }

    public String hello(String name){
        return String.format("Hello %s, your id is %s", name, UUID.randomUUID());
    }
}
