package com.fasipe.biomedicina.Requests;

import java.util.Date;

public record RequestExameseAmostras(
        Long id,
        String nomeexame,
        Boolean tipo,
//        Date dtrealizado,
        Long idcliente,
        Long idinforeferencia,
        Date dataHoraColeta,
        String nomeProfissional,
        Integer numAmostras,
        String condicoesColeta,
        String identificacaoTubos,
        String tempoArmazenamento,
        String condicoesTransporte,
        String observacoes,
        String reacoesAdversas,
        String acompanhamentoAdicional
) {
}
