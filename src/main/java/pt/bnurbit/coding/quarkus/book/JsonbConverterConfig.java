package pt.bnurbit.coding.quarkus.book;

import io.quarkus.jsonb.JsonbConfigCustomizer;

import javax.json.bind.JsonbConfig;

public class JsonbConverterConfig implements JsonbConfigCustomizer {

    @Override
    public void customize(JsonbConfig jsonbConfig) {
        // Can be used to add support for custom data types (DateTime)
    }
}
