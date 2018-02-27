package com.codecool.adhoc.ticketportal.services;

import com.codecool.adhoc.ticketportal.model.Band;
import com.codecool.adhoc.ticketportal.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {


    @Autowired
    BandRepository bandRepository;


    public List<Band> findAllBand(){
        return bandRepository.findAll();
    }

    public Band findBandById(Long id){
        return bandRepository.findOne(id);
    }

    public void saveBand(Band band){
        bandRepository.save(band);
    }
}
