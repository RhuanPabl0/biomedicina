package com.fasipe.biomedicina.Repositorys;

import com.fasipe.biomedicina.Entitys.ResultadoExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoExameRepository extends JpaRepository<ResultadoExame, Long> {
}
