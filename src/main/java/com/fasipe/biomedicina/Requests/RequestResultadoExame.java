package com.fasipe.biomedicina.Requests;

import com.fasipe.biomedicina.Entitys.InfoReferencia;
import com.fasipe.biomedicina.Entitys.Paciente;
import com.fasipe.biomedicina.Entitys.Procedimentos;
import com.fasipe.biomedicina.Users.User;

import java.util.Date;

public record RequestResultadoExame(
        Paciente paciente,
        Procedimentos procedimentos,
        User user,
        InfoReferencia infoReferencia,
        Long valor,
        String medida,
        String observacao,
        String linkresultado,
        Date dtresultado
) {
}
