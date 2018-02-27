package com.codecool.adhoc.ticketportal.repository;

import com.codecool.adhoc.ticketportal.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends JpaRepository<Band, Long>{
    /*
    TODO: Band queries

    -* findBandById
    - findAllBands
    - findBandByName
    - findBandByMusicStyle
    -* findBandsByEvent

     */
}
