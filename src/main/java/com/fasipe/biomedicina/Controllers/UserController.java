package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Exception.ResourceNotFoundException;
import com.fasipe.biomedicina.Repositorys.UserRepository;
import com.fasipe.biomedicina.Users.RegisterDTO;
import com.fasipe.biomedicina.Users.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUserPorId(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dados não encontrado com o ID: " + id));
    }
    @GetMapping("/login/{login}")
    public ResponseEntity getUserPorLogin(@PathVariable String login) {
        User user = userRepository.findByLoginIgnoreCase(login);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            throw new ResourceNotFoundException("Usuário não encontrado com o login: " + login);
        }
    }
    @GetMapping
    public ResponseEntity getAllUsers(){
        var allUser = userRepository.findAll();
        return ResponseEntity.ok(allUser);
    }
}
