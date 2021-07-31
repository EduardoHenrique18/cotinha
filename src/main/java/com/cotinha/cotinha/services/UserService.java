package com.cotinha.cotinha.services;


import com.cotinha.cotinha.exceptions.ExistingEmail;
import com.cotinha.cotinha.models.User;
import com.cotinha.cotinha.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    Userrepository userrepository;

    public User emailSave(User user) throws ExistingEmail {
        User user1 = userrepository.findByEmail(user.getEmail());
        if (user1 != null){
            throw new ExistingEmail("Email existente para: "+ user.getEmail());

        }else {
            userrepository.save(user);
        }
        return user;
    }
}

