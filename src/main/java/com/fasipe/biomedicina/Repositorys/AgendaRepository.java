package com.fasipe.biomedicina.Repositorys;

import com.fasipe.biomedicina.Entitys.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByUserId(Long userId);
    List<Agenda> findByVisita(String visita);
    List<Agenda> findByUserLoginAndVisita(String userLogin, String visita);
}
