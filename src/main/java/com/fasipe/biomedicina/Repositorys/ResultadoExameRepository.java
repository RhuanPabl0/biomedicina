package com.fasipe.biomedicina.Repositorys;

import com.fasipe.biomedicina.Entitys.ResultadoExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoExameRepository extends JpaRepository<ResultadoExame, Long> {
    List<ResultadoExame> findByIdprofissional(Long idprofissional);
}
