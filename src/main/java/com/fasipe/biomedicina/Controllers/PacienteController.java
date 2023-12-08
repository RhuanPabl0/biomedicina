package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Entitys.Paciente;
import com.fasipe.biomedicina.Entitys.Procedimentos;
import com.fasipe.biomedicina.Exception.ResourceNotFoundException;
import com.fasipe.biomedicina.Repositorys.PacienteRepository;
import com.fasipe.biomedicina.Requests.RequestPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/{cpfpac}")
    public Paciente getPacientePorId(@PathVariable Long cpfpac) {
        return pacienteRepository.findById(cpfpac)
                .orElseThrow(() -> new ResourceNotFoundException("Dados não encontrado com o ID: " + cpfpac));
    }

    @GetMapping
    public ResponseEntity getPaciente(){
        var allPaciente = pacienteRepository.findAll();
        return ResponseEntity.ok(allPaciente);
    }
}
