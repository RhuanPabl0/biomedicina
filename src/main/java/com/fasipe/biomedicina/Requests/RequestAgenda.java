package com.fasipe.biomedicina.Requests;

import com.fasipe.biomedicina.Entitys.Paciente;
import com.fasipe.biomedicina.Entitys.Procedimentos;
import com.fasipe.biomedicina.Users.User;

import java.util.Date;

public record RequestAgenda(
        Long id,
        Paciente paciente,
        Procedimentos procedimentos,
        User user,
        Date dataConsulta
) {
}
