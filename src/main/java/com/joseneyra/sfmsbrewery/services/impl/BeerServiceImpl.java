package com.joseneyra.sfmsbrewery.services.impl;

import com.joseneyra.sfmsbrewery.services.BeerService;
import com.joseneyra.sfmsbrewery.web.model.BeerDataTransferObject;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDataTransferObject getBeerById(UUID beerId) {
        return BeerDataTransferObject.builder().
                id(UUID.randomUUID()).
                beerName("Galaxy Cat").
                beerStyle("Pale Ale").
                upc(3L).
                build();
    }

    @Override
    public BeerDataTransferObject saveNewBeer(BeerDataTransferObject beerDto) {
        return BeerDataTransferObject.builder().
                id(UUID.randomUUID()).
                build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDataTransferObject beerDto) {
        // TODO
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        // TODO
    }
}
