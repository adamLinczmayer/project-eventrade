package com.codecool.adhoc.ticketportal.repository;

import com.codecool.adhoc.ticketportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserName(String name);

}
