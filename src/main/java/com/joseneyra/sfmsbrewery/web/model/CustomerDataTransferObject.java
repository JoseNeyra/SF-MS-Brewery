package com.joseneyra.sfmsbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDataTransferObject {

    @Null
    private UUID id;

    @NotBlank
    //    @Min(3)               /// Min and Max are for numbers, for string size  you need to use the Size annotation
    //    @Max(100)
    @Size(min = 3, max = 100)
    private String name;
}
