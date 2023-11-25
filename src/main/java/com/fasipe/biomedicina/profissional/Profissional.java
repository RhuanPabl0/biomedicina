package com.fasipe.biomedicina.profissional;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "profissional")
@Entity(name = "profissional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profissional {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codprof;
    private String nomeprof;
    private Integer tipoprof;
    private Integer supprof;
    private Integer statusprof;
    private String consprof;

    public Profissional(RequestProfissional requestProfissional){
        this.nomeprof = requestProfissional.nomeprof();
        this.tipoprof = requestProfissional.tipoprof();
        this.supprof = requestProfissional.supprof();
        this.statusprof = requestProfissional.statuspro();
        this.consprof = requestProfissional.consprof();
    }


}
