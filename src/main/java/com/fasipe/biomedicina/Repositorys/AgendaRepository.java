package com.fasipe.biomedicina.Repositorys;

import com.fasipe.biomedicina.Entitys.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByUserId(Long userId);
    List<Agenda> findByVisita(String visita);
    List<Agenda> findByUserLoginAndVisita(String userLogin, String visita);

    @Query("SELECT a FROM Agenda a WHERE a.user.login = :login AND a.visita = :visita AND DATE(a.dataConsulta) = DATE(:dataConsulta)")
    List<Agenda> findByUserLoginAndVisitaAndDataConsulta(
            @Param("login") String login,
            @Param("visita") String visita,
            @Param("dataConsulta") Date dataConsulta
    );
}
