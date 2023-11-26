package com.fasipe.biomedicina.Requests;

public record RequestProcedimentos(

        Long id,
        Integer codProced,

        String descProced,

        Double valProced
) {
}
