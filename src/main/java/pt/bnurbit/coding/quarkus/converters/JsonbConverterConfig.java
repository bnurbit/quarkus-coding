package pt.bnurbit.coding.quarkus.converters;

import io.quarkus.jsonb.JsonbConfigCustomizer;

import javax.json.bind.JsonbConfig;

// Can be used to add support for custom data types (DateTime)
public class JsonbConverterConfig implements JsonbConfigCustomizer {

    @Override
    public void customize(JsonbConfig jsonbConfig) {

    }
}
