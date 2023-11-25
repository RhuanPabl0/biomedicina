package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Procedimentos.Procedimentos;
import com.fasipe.biomedicina.Procedimentos.ProcedimentosRepository;
import com.fasipe.biomedicina.Procedimentos.RequestProcedimentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentosRepository procedimentosRepository;
    @GetMapping

    public ResponseEntity getAllProcedimentos(){
        var allProcedimentos = procedimentosRepository.findAll();
        return ResponseEntity.ok(allProcedimentos);
    }
    @PostMapping
    public ResponseEntity postProcedimentos (@RequestBody RequestProcedimentos data){
        Procedimentos newProcedimento = new Procedimentos(data);
        procedimentosRepository.save(newProcedimento);
        return ResponseEntity.ok().build();
    }
}
