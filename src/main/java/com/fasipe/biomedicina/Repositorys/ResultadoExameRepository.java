package com.fasipe.biomedicina.Repositorys;

import com.fasipe.biomedicina.Entitys.ResultadoExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoExameRepository extends JpaRepository<ResultadoExame, Long> {
    @Query("SELECT re FROM resultadoexame re WHERE re.user.login = :login")
    List<ResultadoExame> findByUserLogin(@Param("login") String login);
}
