package com.fasipe.biomedicina.Entitys;


import com.fasipe.biomedicina.Requests.RequestResultadoExame;
import com.fasipe.biomedicina.Users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "resultadoexame")
@Table(name = "resultadoexame")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ResultadoExame {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "idcliente")
    private Long idcliente;
    @Column(name = "idprocedimentos")
    private Long idprocedimentos;
    @Column(name = "idprofissional")
    private Long idprofissional;
    @Column(name = "idreferencia")
    private Long idreferencia;
    @Column(name = "valor")
    private Long valor;
    @Column(name = "medida")
    private String medida;
    private String linkresultado;
    private Date dtresultado;
    public ResultadoExame(RequestResultadoExame requestResultadoExame){
        this.idcliente = requestResultadoExame.idcliente();
        this.idprocedimentos = requestResultadoExame.idprocedimentos();
        this.idprofissional = requestResultadoExame.idprofissional();
        this.idreferencia = requestResultadoExame.idreferencia();
        this.valor = requestResultadoExame.valor();
        this.medida = requestResultadoExame.medida();
        this.linkresultado = requestResultadoExame.linkresultado();
        this.dtresultado = requestResultadoExame.dtresultado();
    }

}
