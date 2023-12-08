package com.fasipe.biomedicina.Entitys;


import com.fasipe.biomedicina.Requests.RequestInfoProcedimento;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "infoprocedimento")
@Entity(name = "infoprocedimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
