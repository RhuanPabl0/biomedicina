package com.fasipe.biomedicina.Entitys;


import com.fasipe.biomedicina.Requests.RequestInfoProcedimento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "infoprocedimento")
@Entity(name = "infoprocedimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoProcedimento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idprocedimento;
    private Long idprofissional;
    private Long idpaciente;
    private Long idinforeferencia;


    public InfoProcedimento(RequestInfoProcedimento requestInfoProcedimento){
        this.idprocedimento = requestInfoProcedimento.idprocedimento();
        this.idprofissional = requestInfoProcedimento.idprofissional();
        this.idpaciente = requestInfoProcedimento.idpaciente();
        this.idinforeferencia = requestInfoProcedimento.idinforeferencia();
    }

}
