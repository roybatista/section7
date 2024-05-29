package com.batista.spring6restmvc.service;

import com.batista.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> getBeers();

    Beer getById(UUID id);

    Beer saveBeer(Beer beer);

}
