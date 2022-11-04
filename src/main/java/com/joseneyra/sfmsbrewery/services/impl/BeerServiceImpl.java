package com.joseneyra.sfmsbrewery.services.impl;

import com.joseneyra.sfmsbrewery.services.BeerService;
import com.joseneyra.sfmsbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().
                id(UUID.randomUUID()).
                beerName("Galaxy Cat").
                beerStyle("Pale Ale").
                upc(3L).
                build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().
                id(UUID.randomUUID()).
                build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // TODO
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        // TODO
    }
}
