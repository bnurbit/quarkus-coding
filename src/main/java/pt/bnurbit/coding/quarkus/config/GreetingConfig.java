package pt.bnurbit.coding.quarkus.config;

import io.quarkus.arc.config.ConfigProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.Optional;

@ConfigProperties(prefix = "greeting")
@Getter
@Setter
public class GreetingConfig {

    // needs quarkus-hibernate-validator extension
    @Size(max = 10, message = "name length cannot be greater than 10")
    private String name;
    private String suffix = "english";
    private Optional<String> prefix;
    private CountryConfig country;

    @Getter
    @Setter
    public static class CountryConfig {
        private String name;
        private String id;
    }
}
