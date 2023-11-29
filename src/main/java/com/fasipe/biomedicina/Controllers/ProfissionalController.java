package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Repositorys.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @GetMapping
    private ResponseEntity getProfissional(){
        var allProfissional = profissionalRepository.findAll();
        return ResponseEntity.ok(allProfissional);
    }
}
