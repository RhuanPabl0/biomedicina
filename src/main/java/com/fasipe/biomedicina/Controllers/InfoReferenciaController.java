package com.fasipe.biomedicina.Controllers;


import com.fasipe.biomedicina.Entitys.InfoReferencia;
import com.fasipe.biomedicina.Exception.ResourceNotFoundException;
import com.fasipe.biomedicina.Repositorys.InfoRefenciaRepository;
import com.fasipe.biomedicina.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("/inforeferencia")
public class InfoReferenciaController {
    @Autowired
    private InfoRefenciaRepository infoRefenciaRepository;
    @GetMapping("/{id}")
    public InfoReferencia getInfoReferenciaPorId(@PathVariable Long id) {
        return infoRefenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dados não encontrado com o ID: " + id));
    }
    @GetMapping
    public ResponseEntity getAllInfoReferencia(){
        var allInforefencia = infoRefenciaRepository.findAll();
        return ResponseEntity.ok(allInforefencia);
    }
}
