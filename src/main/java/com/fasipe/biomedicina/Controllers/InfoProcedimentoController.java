package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Entitys.InfoProcedimento;
import com.fasipe.biomedicina.Repositorys.InfoProcedimentoRepository;
import com.fasipe.biomedicina.Requests.RequestInfoProcedimento;
import com.fasipe.biomedicina.Requests.RequestProcedimentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("/infoprocedimento")
public class InfoProcedimentoController {

    @Autowired
    public InfoProcedimentoRepository infoProcedimentoRepository;

    @GetMapping
    public ResponseEntity getAllInfoProcedimento(){
        var allInfoProcedimento = infoProcedimentoRepository.findAll();
        return ResponseEntity.ok(allInfoProcedimento);
    }

    @PostMapping
    public ResponseEntity postInfoProcedimento(@RequestBody RequestInfoProcedimento data){
        InfoProcedimento newInfoProcedimento = new InfoProcedimento(data);
        infoProcedimentoRepository.save(newInfoProcedimento);
        return ResponseEntity.ok().build();
    }
}
