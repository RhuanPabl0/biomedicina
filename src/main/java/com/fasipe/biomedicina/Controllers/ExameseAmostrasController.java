package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Entitys.ExameseAmostras;
import com.fasipe.biomedicina.Exception.ResourceNotFoundException;
import com.fasipe.biomedicina.Repositorys.ExameseAmostrasRepository;
import com.fasipe.biomedicina.Requests.RequestExameseAmostras;
import com.fasipe.biomedicina.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exameseamostras")
public class ExameseAmostrasController {

    @Autowired
    private ExameseAmostrasRepository exameseAmostrasRepository;
    @GetMapping("/{id}")
    public ExameseAmostras getUserPorId(@PathVariable Long id) {
        return exameseAmostrasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dados não encontrado com o ID: " + id));
    }
    @GetMapping
    private ResponseEntity getAllExameseAmostras(){
        var allExameseAmostras = exameseAmostrasRepository.findAll();
        return ResponseEntity.ok(allExameseAmostras);
    }

    @PostMapping
    public ResponseEntity postExamesAmostras(@RequestBody RequestExameseAmostras data){
        ExameseAmostras newExameseAmostras = new ExameseAmostras(data);
        exameseAmostrasRepository.save(newExameseAmostras);
        return ResponseEntity.ok().build();
    }
}
