package com.fasipe.biomedicina.Requests;

public record RequestInfoProcedimento(

        Long id,
        Long idprocedimento,
        Long idprofissional,
        Long idpaciente,
        Long idinforeferencia
) {
}
