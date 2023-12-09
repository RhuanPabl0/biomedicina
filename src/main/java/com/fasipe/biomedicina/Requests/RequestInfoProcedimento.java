package com.fasipe.biomedicina.Requests;

import com.fasipe.biomedicina.Entitys.InfoReferencia;
import com.fasipe.biomedicina.Entitys.Paciente;
import com.fasipe.biomedicina.Entitys.Procedimentos;
import com.fasipe.biomedicina.Users.User;

public record RequestInfoProcedimento(
        Long idprocedimento,
        Long idprofissional,
        Long idpaciente,
        Long idinforeferencia
) {
}
