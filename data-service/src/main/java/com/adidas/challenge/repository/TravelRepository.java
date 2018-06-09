package com.adidas.challenge.repository;

import org.springframework.data.repository.CrudRepository;
import com.adidas.challenge.domain.TravelEntity;

public interface TravelRepository extends CrudRepository<TravelEntity, Long> {

}
