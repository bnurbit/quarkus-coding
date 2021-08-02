package pt.bnurbit.coding.quarkus.greeting;

import org.eclipse.microprofile.config.spi.Converter;

public class Base64ValueConverter implements Converter<Base64Value> {

    @Override
    public Base64Value convert(String s) {
        return new Base64Value(s);
    }
}
