package com.cotinha.cotinha.controlers;

import com.cotinha.cotinha.exceptions.ExistingEmail;
import com.cotinha.cotinha.models.User;
import com.cotinha.cotinha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/user")
public class UserControler {

    @Autowired
    UserService userService;

    @RequestMapping( value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody User user) throws ExistingEmail {
        userService.emailSave(user);
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/register").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
