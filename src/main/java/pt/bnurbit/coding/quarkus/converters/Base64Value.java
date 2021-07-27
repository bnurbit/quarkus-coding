package pt.bnurbit.coding.quarkus.converters;

import lombok.Getter;
import lombok.Setter;

import java.util.Base64;

@Getter
@Setter
public class Base64Value {

    private String value;

    public Base64Value(String value) {
        this.value = new String(Base64.getDecoder().decode(value));
    }
}
