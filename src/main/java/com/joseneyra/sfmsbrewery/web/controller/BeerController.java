package com.joseneyra.sfmsbrewery.web.controller;

import com.joseneyra.sfmsbrewery.web.model.BeerDataTransferObject;
import com.joseneyra.sfmsbrewery.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Deprecated     // Added this annotation because we just updated to API to V2
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")                                                                                // beerId is a path variable
    public ResponseEntity<BeerDataTransferObject> getBeer(@PathVariable("beerId") UUID beerId) {            // @PathVariable maps the incoming "beerId" in path to the variable. Not needed if the two have the same name
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDataTransferObject> handlePost (@Valid @RequestBody BeerDataTransferObject beerDto) {
        BeerDataTransferObject savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // TODO: add hostname to url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDataTransferObject> handleUpdate(@PathVariable("beerId") UUID beerId,
                                                               @Valid @RequestBody BeerDataTransferObject beerDto) {
        beerService.updateBeer(beerId, beerDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDeleter (@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeerById(beerId);
    }
}
