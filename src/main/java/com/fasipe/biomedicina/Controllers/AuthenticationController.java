package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Repositorys.UserRepository;
import com.fasipe.biomedicina.Users.AuthenticationDTO;
import com.fasipe.biomedicina.Users.LoginResponseDTO;
import com.fasipe.biomedicina.Users.RegisterDTO;
import com.fasipe.biomedicina.Users.User;
import com.fasipe.biomedicina.infra.Security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.nome(), data.login(), encryptedPassword, data.role(), data.sup(), data.status(), data.cons());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
