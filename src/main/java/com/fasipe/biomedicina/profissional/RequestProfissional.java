package com.fasipe.biomedicina.profissional;

public record RequestProfissional(

        Long codprof,
        String nomeprof,
        Integer tipoprof,
        Integer supprof,
        Integer statuspro,
        String consprof
) {
}
