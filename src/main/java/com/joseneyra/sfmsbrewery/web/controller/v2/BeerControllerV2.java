package com.joseneyra.sfmsbrewery.web.controller.v2;

import com.joseneyra.sfmsbrewery.services.v2.BeerServiceV2;
import com.joseneyra.sfmsbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")                                                                                // beerId is a path variable
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {            // @PathVariable maps the incoming "beerId" in path to the variable. Not needed if the two have the same name
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> handlePost (@RequestBody BeerDtoV2 beerDto) {
        BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // TODO: add hostname to url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> handleUpdate(@PathVariable("beerId") UUID beerId,
                                                               @RequestBody BeerDtoV2 beerDto) {
        beerService.updateBeer(beerId, beerDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDeleter (@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeerById(beerId);
    }
}
