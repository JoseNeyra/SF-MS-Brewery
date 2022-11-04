package com.joseneyra.sfmsbrewery.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data                           // Creates Getters, Setters, Equals and HashCodes
@NoArgsConstructor
@AllArgsConstructor
@Builder                        // Allows to build the object using the builder pattern
public class BeerDtoV2 {

    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private BeerStyleEnum beerStyle;

    @Positive
    private Long upc;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;
}