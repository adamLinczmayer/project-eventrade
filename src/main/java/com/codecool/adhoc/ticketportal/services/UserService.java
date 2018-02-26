package com.codecool.adhoc.ticketportal.services;

import com.codecool.adhoc.ticketportal.model.User;
import com.codecool.adhoc.ticketportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }
}
