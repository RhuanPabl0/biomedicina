package com.fasipe.biomedicina.Entitys;


import com.fasipe.biomedicina.Requests.RequestInfoProcedimento;
import com.fasipe.biomedicina.Users.User;
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
    @Column(name = "idprocedimento")
    private Long idprocedimento;
    @Column(name = "idprofissional")
    private Long idprofissional;
    @Column(name = "idpaciente")
    private Long idpaciente;
    @Column(name = "idinforeferencia")
    private Long idinforeferencia;

    public InfoProcedimento(RequestInfoProcedimento requestInfoProcedimento){
        this.idprocedimento = requestInfoProcedimento.idprocedimento();
        this.idprofissional = requestInfoProcedimento.idprofissional();
        this.idpaciente = requestInfoProcedimento.idpaciente();
        this.idinforeferencia = requestInfoProcedimento.idinforeferencia();
    }
}
