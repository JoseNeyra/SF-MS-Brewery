package com.joseneyra.sfmsbrewery.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data                           // Creates Getters, Setters, Equals and HashCodes
@NoArgsConstructor
@AllArgsConstructor
@Builder                        // Allows to build the object using the builder pattern
public class BeerDtoV2 {

    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
}