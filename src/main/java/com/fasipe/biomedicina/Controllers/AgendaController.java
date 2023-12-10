package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Entitys.Agenda;
import com.fasipe.biomedicina.Entitys.Paciente;
import com.fasipe.biomedicina.Exception.ResourceNotFoundException;
import com.fasipe.biomedicina.Repositorys.AgendaRepository;
import com.fasipe.biomedicina.Requests.RequestAgenda;
import com.fasipe.biomedicina.Requests.RequestExameseAmostras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", originPatterns = "*")
@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;


    @GetMapping("/{id}")
    public Agenda getAgendaPorId(@PathVariable Long id) {
        return agendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dados não encontrado com o ID: " + id));
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity getAgendaByUser(@PathVariable Long userId) {
        List<Agenda> agendaList = agendaRepository.findByUserId(userId);

        if (agendaList.isEmpty()) {
            throw new ResourceNotFoundException("Agendas não encontradas para o usuário com ID: " + userId);
        }

        return ResponseEntity.ok(agendaList);
    }
    @GetMapping
    private ResponseEntity getAllAgenda(){
        var allAgenda = agendaRepository.findAll();
        return ResponseEntity.ok(allAgenda);
    }


}
