package com.fasipe.biomedicina.Requests;

import java.util.Date;

public record RequestPaciente(

         Long cpfpac,
         String nomepac,
         Integer codpac,
         Long telpac,
         Integer ceppac,
         String lograpac,
         Integer numlograpac,
         String complpac,
         String bairropac,
         String cidadepac,
         String ufpac,
         Long rgpac,
         String estrgpac,
         String nomemaepac,
         Date dtnascpac
) {
}
