package com.codecool.adhoc.ticketportal.repository;

import com.codecool.adhoc.ticketportal.model.Band;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

    List<Band> findBandsByMusicStyle(MusicStyle musicStyle);

}
