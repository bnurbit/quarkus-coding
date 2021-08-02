package pt.bnurbit.coding.quarkus.crypto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
@NoArgsConstructor
public class Currency {

    private String id;

    private String symbol;

    private String name;

    @JsonbProperty("price_usd")
    private String priceUsd;

    private int rank;
}
