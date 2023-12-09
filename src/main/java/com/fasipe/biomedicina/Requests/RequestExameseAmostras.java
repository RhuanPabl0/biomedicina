package com.fasipe.biomedicina.Requests;

import com.fasipe.biomedicina.Entitys.InfoReferencia;
import com.fasipe.biomedicina.Entitys.Paciente;
import jakarta.persistence.*;

import java.util.Date;

public record RequestExameseAmostras(
        Long id,
        String nomeexame,
        Boolean tipo,
        Date dtrealizado,
        Long idcliente,
        Long idinforeferencia
) {
}
