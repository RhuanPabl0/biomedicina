package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Entitys.ResultadoExame;
import com.fasipe.biomedicina.Exception.ResourceNotFoundException;
import com.fasipe.biomedicina.Repositorys.ResultadoExameRepository;
import com.fasipe.biomedicina.Requests.RequestResultadoExame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/byUserLogin/{login}")
    public ResponseEntity<?> getResultadoExameByUserLogin(@PathVariable String login) {
        List<ResultadoExame> resultadoExameList = resultadoExameRepository.findByUserLogin(login);

        if (resultadoExameList.isEmpty()) {
            return ResponseEntity.ok("Sem resultados de exame para este usuário");
        }

        return ResponseEntity.ok(resultadoExameList);
    }


    @GetMapping
    private ResponseEntity getAllResultadoExame(){
        var allResultadoExame = resultadoExameRepository.findAll();
        return ResponseEntity.ok(allResultadoExame);
    }
    @PostMapping
    public ResponseEntity<ResultadoExame> postResultadoExame(@RequestBody RequestResultadoExame data) {
        ResultadoExame newResultado = new ResultadoExame(data);
        ResultadoExame savedResultado = resultadoExameRepository.save(newResultado);
        return ResponseEntity.ok(savedResultado);
    }
}
