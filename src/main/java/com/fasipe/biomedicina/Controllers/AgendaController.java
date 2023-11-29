package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Repositorys.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping
    private ResponseEntity getAllAgenda(){
        var allAgenda = agendaRepository.findAll();
        return ResponseEntity.ok(allAgenda);
    }
}
