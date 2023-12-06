package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Repositorys.UserRepository;
import com.fasipe.biomedicina.Users.RegisterDTO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public ResponseEntity getAllUsers(){
        var allUser = userRepository.findAll();
        return ResponseEntity.ok(allUser);
    }
}
