package pt.bnurbit.coding.quarkus.config;

import io.quarkus.arc.config.ConfigProperties;

import javax.validation.constraints.Size;
import java.util.Optional;

@ConfigProperties(prefix = "greeting")
public class GreetingConfig {

    // needs quarkus-hibernate-validator extension
    @Size(max = 10, message = "name length cannot be greater than 10")
    private String name;
    private String suffix = "english";
    private Optional<String> prefix;
    private CountryConfig country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Optional<String> getPrefix() {
        return prefix;
    }

    public void setPrefix(Optional<String> prefix) {
        this.prefix = prefix;
    }

    public CountryConfig getCountry() {
        return country;
    }

    public void setCountry(CountryConfig country) {
        this.country = country;
    }

    public static class CountryConfig {
        private String name;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
