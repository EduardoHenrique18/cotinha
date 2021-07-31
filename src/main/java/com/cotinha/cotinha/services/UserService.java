package com.cotinha.cotinha.services;

import com.cotinha.cotinha.exceptions.ExistingEmail;
import com.cotinha.cotinha.models.User;
import com.cotinha.cotinha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User emailSave(User user) throws ExistingEmail {
        User userCondicion = userRepository.findByEmail(user.getEmail());

        if (userCondicion != null) {
            throw new ExistingEmail("Email existente para: " + user.getEmail());
        }
        return userRepository.save(user);
    }
}

