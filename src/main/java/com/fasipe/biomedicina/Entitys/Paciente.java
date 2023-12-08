package com.fasipe.biomedicina.Entitys;

import com.fasipe.biomedicina.Requests.RequestPaciente;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Table(name = "paciente")
@Entity(name = "paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cpfpac")
public class Paciente {
    @Id
    private Long cpfpac;
    private String nomepac;
    private Integer codpac;
    private Long telpac;
    private Integer ceppac;
    private String lograpac;
    private  Integer numlograpac;
    private String complpac;
    private String bairropac;
    private String cidadepac;
    private String ufpac;
    private Long rgpac;
    private String estrgpac;
    private String nomemaepac;
    private Date dtnascpac;

    public Paciente(RequestPaciente requestPaciente){
        this.cpfpac = requestPaciente.cpfpac();
        this.nomepac = requestPaciente.nomepac();
        this.codpac = requestPaciente.codpac();
        this.telpac = requestPaciente.telpac();
        this.ceppac = requestPaciente.ceppac();
        this.lograpac = requestPaciente.lograpac();
        this.numlograpac = requestPaciente.numlograpac();
        this.complpac = requestPaciente.complpac();
        this.bairropac = requestPaciente.bairropac();
        this.cidadepac = requestPaciente.cidadepac();
        this.ufpac = requestPaciente.ufpac();
        this.rgpac = requestPaciente.rgpac();
        this.estrgpac = requestPaciente.estrgpac();
        this.nomemaepac = requestPaciente.nomemaepac();
        this.dtnascpac = requestPaciente.dtnascpac();
    }
}
