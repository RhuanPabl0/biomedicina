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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "cpfpac")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idprocedimentos", referencedColumnName = "cod")
    private Procedimentos procedimentos;

    @ManyToOne
    @JoinColumn(name = "id_profissional", referencedColumnName = "codprof")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idreferencia", referencedColumnName = "id")
    private InfoReferencia infoReferencia;

    @Column(name = "valor")
    private Long valor;

    @Column(name = "medida")
    private String medida;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "linkresultado")
    private String linkresultado;

    @Column(name = "dtresultado")
    private Date dtresultado;

    public ResultadoExame(RequestResultadoExame requestResultadoExame) {
        this.paciente = requestResultadoExame.paciente();
        this.procedimentos = requestResultadoExame.procedimentos();
        this.user = requestResultadoExame.user();
        this.infoReferencia = requestResultadoExame.infoReferencia();
        this.valor = requestResultadoExame.valor();
        this.medida = requestResultadoExame.medida();
        this.observacao = requestResultadoExame.observacao();
        this.linkresultado = requestResultadoExame.linkresultado();
        this.dtresultado = requestResultadoExame.dtresultado();
    }
}
