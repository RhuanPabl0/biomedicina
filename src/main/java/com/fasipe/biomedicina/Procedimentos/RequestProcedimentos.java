package com.fasipe.biomedicina.Procedimentos;

public record RequestProcedimentos(

        Long id,
        Integer codProced,

        String descProced,

        Double valProced
) {
}
