package com.codecool.adhoc.ticketportal.services;

import com.codecool.adhoc.ticketportal.model.Band;
import com.codecool.adhoc.ticketportal.model.Event;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
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

    public Band saveBand(Band band){
        return bandRepository.save(band);
    }

    public List<Band> findBandByMusicStyleString(String musicStyleString) {
        if (!musicStyleString.equals("")) {
            MusicStyle musicStyle = MusicStyle.valueOf(musicStyleString.toUpperCase());
            return findBandByMusicStyle(musicStyle);
        } else {
            return findAllBand();
        }
    }

    private List<Band> findBandByMusicStyle(MusicStyle musicStyle) {
        return bandRepository.findBandsByMusicStyle(musicStyle);
    }

}
