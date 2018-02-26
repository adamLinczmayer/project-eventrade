package com.codecool.adhoc.ticketportal.repository;

import com.codecool.adhoc.ticketportal.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{
}
