package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Entitys.Paciente;
import com.fasipe.biomedicina.Repositorys.PacienteRepository;
import com.fasipe.biomedicina.Requests.RequestPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity getPaciente(){
        var allPaciente = pacienteRepository.findAll();
        return ResponseEntity.ok(allPaciente);
    }
}
