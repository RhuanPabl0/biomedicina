package com.fasipe.biomedicina.Requests;

public record RequestProcedimentos(

        Long id,
        Long codProced,

        String descProced,

        Double valProced
) {
}
