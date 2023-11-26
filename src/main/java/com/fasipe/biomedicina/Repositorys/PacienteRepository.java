package com.fasipe.biomedicina.Repositorys;

import com.fasipe.biomedicina.Entitys.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
