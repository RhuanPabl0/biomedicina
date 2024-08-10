package com.fasipe.biomedicina.Controllers;

import com.fasipe.biomedicina.Entitys.Agenda;
import com.fasipe.biomedicina.Exception.ResourceNotFoundException;
import com.fasipe.biomedicina.Repositorys.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> getAgendaByUser(@PathVariable Long userId) {
        List<Agenda> agendaList = agendaRepository.findByUserId(userId);

        if (agendaList.isEmpty()) {
            return ResponseEntity.ok("Sem agendamentos marcados");
        }

        return ResponseEntity.ok(agendaList);
    }

    @GetMapping("/byVisita/{visita}")
    public ResponseEntity<?> getAgendaByVisita(@PathVariable String visita) {
        List<Agenda> agendaList = agendaRepository.findByVisita(visita);

        if (agendaList.isEmpty()) {
            return ResponseEntity.ok("Sem agendamentos marcados");
        }

        return ResponseEntity.ok(agendaList);
    }

    @GetMapping("/byLoginAndVisita")
    public ResponseEntity<?> getAgendaByLoginAndVisita(@RequestParam String login, @RequestParam String visita) {
        List<Agenda> agendaList = agendaRepository.findByUserLoginAndVisita(login, visita);

        if (agendaList.isEmpty()) {
            return ResponseEntity.ok("Sem agendamentos marcados");
        }

        return ResponseEntity.ok(agendaList);
    }

    @GetMapping
    private ResponseEntity<?> getAllAgenda() {
        var allAgenda = agendaRepository.findAll();

        if (allAgenda.isEmpty()) {
            return ResponseEntity.ok("Sem agendamentos marcados");
        }

        return ResponseEntity.ok(allAgenda);
    }

    @PutMapping("/{id}/visita")
    public ResponseEntity<Agenda> updateVisita(@PathVariable Long id, @RequestParam String visita) {
        Optional<Agenda> optionalAgenda = agendaRepository.findById(id);
        if (optionalAgenda.isEmpty()) {
            throw new ResourceNotFoundException("Agenda não encontrada com o ID: " + id);
        }

        Agenda agenda = optionalAgenda.get();
        agenda.setVisita(visita);
        agendaRepository.save(agenda);

        return ResponseEntity.ok(agenda);
    }
    @GetMapping("/byLoginVisitaData")
    public ResponseEntity<?> getAgendaByLoginVisitaAndDataConsulta(@RequestParam String login) {
        Date currentDate = getCurrentDateWithoutTime();
        List<Agenda> agendaList = agendaRepository.findByUserLoginAndVisitaAndDataConsulta(login, "sim", currentDate);

        if (agendaList.isEmpty()) {
            return ResponseEntity.ok("Sem agendamentos marcados");
        }

        return ResponseEntity.ok(agendaList);
    }

    private Date getCurrentDateWithoutTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
