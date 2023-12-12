package com.fasipe.biomedicina.Requests;

import com.fasipe.biomedicina.Entitys.InfoReferencia;
import com.fasipe.biomedicina.Entitys.Paciente;
import com.fasipe.biomedicina.Entitys.Procedimentos;
import com.fasipe.biomedicina.Users.User;
import jakarta.persistence.Column;

import java.util.Date;

public record RequestResultadoExame(
        Long idcliente,
        Long idprocedimentos,
        Long idprofissional,
        Long idreferencia,
        Long valor,
        String medida,
        String observacao,
        String linkresultado,
        Date dtresultado
) {
}
