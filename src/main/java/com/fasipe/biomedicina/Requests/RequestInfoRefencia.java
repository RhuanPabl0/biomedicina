package com.fasipe.biomedicina.Requests;

import com.fasipe.biomedicina.Entitys.Procedimentos;


public record RequestInfoRefencia(
        Long id,
        Long idprocedimento,
        Double referenciamin,
        Double referenciamax,
        String medida
) {
}
