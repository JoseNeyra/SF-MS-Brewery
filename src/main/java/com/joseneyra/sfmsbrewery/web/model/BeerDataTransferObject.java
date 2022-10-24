package com.joseneyra.sfmsbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data                           // Creates Getters, Setters, Equals and HashCodes
@NoArgsConstructor
@AllArgsConstructor
@Builder                        // Allows to build the object using the builder pattern
public class BeerDataTransferObject {

    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;
}
