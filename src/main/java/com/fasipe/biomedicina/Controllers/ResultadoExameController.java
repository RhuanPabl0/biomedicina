package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Entitys.ResultadoExame;
import com.fasipe.biomedicina.Exception.ResourceNotFoundException;
import com.fasipe.biomedicina.Repositorys.ResultadoExameRepository;
import com.fasipe.biomedicina.Requests.RequestResultadoExame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("/resultadoexame")
public class ResultadoExameController {
    @Autowired
    public ResultadoExameRepository resultadoExameRepository;

    @GetMapping("/{id}")
    public ResultadoExame getResultadoExamePorId(@PathVariable Long id) {
        return resultadoExameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dados não encontrado com o ID: " + id));
    }
    @GetMapping
    private ResponseEntity getAllResultadoExame(){
        var allResultadoExame = resultadoExameRepository.findAll();
        return ResponseEntity.ok(allResultadoExame);
    }
    @PostMapping
    public ResponseEntity postResultadoExame(@RequestBody RequestResultadoExame data) {
        ResultadoExame newResultado = new ResultadoExame(data);
        resultadoExameRepository.save(newResultado);
        return ResponseEntity.ok().build();
    }
}
