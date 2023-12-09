package com.fasipe.biomedicina.Requests;

import com.fasipe.biomedicina.Entitys.Procedimentos;


public record RequestInfoRefencia(
        Long id,
        Procedimentos procedimentos,
        Double referenciamin,
        Double referenciamax,
        String medida
) {
}
