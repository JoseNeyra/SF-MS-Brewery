package com.joseneyra.sfmsbrewery.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.joseneyra.sfmsbrewery.services.impl.BeerServiceImpl
import com.joseneyra.sfmsbrewery.web.model.BeerDataTransferObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.hamcrest.core.Is.is
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ContextConfiguration(classes = [BeerController.class,
                                 BeerServiceImpl.class])
@WebMvcTest
class BeerControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private ObjectMapper objectMapper

    private BeerDataTransferObject validBeer


    void setup() {
        validBeer = BeerDataTransferObject.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .upc(123456789012L)
                .build()
    }

    def "GetBeer"() {
        given:
        def beerService = GroovyStub(BeerServiceImpl, global: true)
        beerService.getBeerById(_ as UUID) >> validBeer

        expect:
        mockMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath('$.beerName', is(validBeer.getBeerName().toString())))
    }

    def "HandlePost"() {
        given:
        def beerDto = validBeer
        beerDto.setId(null)

        def savedDto = BeerDataTransferObject.builder()
                                            .id(UUID.randomUUID())
                                            .beerName("New Beer")
                                            .build()
        def beerDtoJson = objectMapper.writeValueAsString(beerDto)

        def beerService = GroovyStub(BeerServiceImpl)
        beerService.saveNewBeer(_ as BeerDataTransferObject) >> savedDto

        expect:
        mockMvc.perform(post("/api/v1/beer")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(beerDtoJson))
                    .andExpect(status().isCreated())
    }

    def "HandleUpdate"() {
        given:
        def beerDto = validBeer
        beerDto.setId(null)
        String beerDtoJson = objectMapper.writeValueAsString(beerDto)

        expect:
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(beerDtoJson))
                    .andExpect(status().isNoContent())

    }
}
