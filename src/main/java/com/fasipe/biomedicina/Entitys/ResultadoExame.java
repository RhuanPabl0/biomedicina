package com.fasipe.biomedicina.Entitys;


import com.fasipe.biomedicina.Requests.RequestResultadoExame;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "resultadoexame")
@Table(name = "resultadoexame")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoExame {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idcliente;
    private Long idprocedimentos;
    private Long idprofissional;
    private Long idreferencia;
    private String linkresultado;
    private Date dtresultado;

    public ResultadoExame(RequestResultadoExame requestResultadoExame){
        this.idcliente = requestResultadoExame.idcliente();
        this.idprocedimentos = requestResultadoExame.idprocedimentos();
        this.idprofissional = requestResultadoExame.idprofissional();
        this.idreferencia = requestResultadoExame.idreferencia();
        this.linkresultado = requestResultadoExame.linkresultado();
        this.dtresultado = requestResultadoExame.dtresultado();
    }


}
