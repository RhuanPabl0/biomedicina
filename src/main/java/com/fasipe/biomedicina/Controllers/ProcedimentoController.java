package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Entitys.Procedimentos;
import com.fasipe.biomedicina.Exception.ResourceNotFoundException;
import com.fasipe.biomedicina.Repositorys.ProcedimentosRepository;
import com.fasipe.biomedicina.Requests.RequestProcedimentos;
import com.fasipe.biomedicina.Services.ProcedimentoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentosRepository procedimentosRepository;

    @Autowired
    private ProcedimentoService service;


    @GetMapping("/{id}")
    public Procedimentos getProcedimentoPorId(@PathVariable Long id) {
        return procedimentosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dados não encontrado com o ID: " + id));
    }

    @GetMapping
    public List<Procedimentos> getAllProcedimentos(){
          return service.getAllProcedimentos();
    }

//    @GetMapping
//    public ResponseEntity getAllProcedimentos(){
//        var allProcedimentos = procedimentosRepository.findAll();
//        return ResponseEntity.ok(allProcedimentos);
//    }
    @PostMapping
    public ResponseEntity postProcedimentos (@RequestBody RequestProcedimentos data){
        Procedimentos newProcedimento = new Procedimentos(data);
        procedimentosRepository.save(newProcedimento);
        return ResponseEntity.ok().build();
    }
}
