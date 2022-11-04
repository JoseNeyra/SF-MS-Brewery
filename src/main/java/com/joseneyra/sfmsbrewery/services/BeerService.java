package com.joseneyra.sfmsbrewery.services;

import com.joseneyra.sfmsbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeerById(UUID beerId);
}
