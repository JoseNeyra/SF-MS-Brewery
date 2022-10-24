package com.joseneyra.sfmsbrewery.services;

import com.joseneyra.sfmsbrewery.web.model.BeerDataTransferObject;

import java.util.UUID;

public interface BeerService {

    BeerDataTransferObject getBeerById(UUID beerId);

    BeerDataTransferObject saveNewBeer(BeerDataTransferObject beerDto);

    void updateBeer(UUID beerId, BeerDataTransferObject beerDto);

    void deleteBeerById(UUID beerId);
}
