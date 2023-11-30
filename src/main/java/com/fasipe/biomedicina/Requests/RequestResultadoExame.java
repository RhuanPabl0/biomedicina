package com.fasipe.biomedicina.Requests;

import java.util.Date;

public record RequestResultadoExame(

        Long id,
        Long idcliente,
        Long idprocedimentos,
        Long idprofissional,
        Long idreferencia,
        String linkresultado,
        Date dtresultado
) {
}
