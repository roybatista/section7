package com.batista.spring6restmvc.controller;

import com.batista.spring6restmvc.model.Beer;
import com.batista.spring6restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @PostMapping
    public ResponseEntity addBeer(@RequestBody Beer beer) {

        Beer savedBear = beerService.saveBeer(beer);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v1/beer/" + savedBear.getId());
        return new ResponseEntity(savedBear, headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> getBeers(){
        return beerService.getBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBeerByID(@PathVariable("beerId") UUID id){
        log.debug("In controller");
        return beerService.getById(id);
    }
}
