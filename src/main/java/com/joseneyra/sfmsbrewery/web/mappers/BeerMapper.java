package com.joseneyra.sfmsbrewery.web.mappers;

import com.joseneyra.sfmsbrewery.domain.Beer;
import com.joseneyra.sfmsbrewery.web.model.v2.BeerDtoV2;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDtoV2 beerToBeerDto (Beer beer);

    Beer beerDtoToBeer (BeerDtoV2 dto);
}
