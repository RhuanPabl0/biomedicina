package com.fasipe.biomedicina.Entitys;

import com.fasipe.biomedicina.Requests.RequestExameseAmostras;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "ExameseAmostras")
@Table(name = "ExameseAmostras")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ExameseAmostras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomexame")
    private String nomeexame;

    @Column(name = "tipo")
    private Boolean tipo;

//    @Column(name = "dtrealizado")
//    private Date dtrealizado;

    @Column(name = "data_hora_coleta")
    private Date dataHoraColeta;

    @Column(name = "idcliente")
    private Long idcliente;

    @Column(name = "idinforeferencia")
    private Long idinforeferencia;


    @Column(name = "nome_profissional")
    private String nomeProfissional;

    @Column(name = "num_amostras")
    private Integer numAmostras;

    @Column(name = "condicoes_coleta")
    private String condicoesColeta;

    @Column(name = "identificacao_tubos")
    private String identificacaoTubos;

    @Column(name = "tempo_armazenamento")
    private String tempoArmazenamento;

    @Column(name = "condicoes_transporte")
    private String condicoesTransporte;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "reacoes_adversas")
    private String reacoesAdversas;

    @Column(name = "acompanhamento_adicional")
    private String acompanhamentoAdicional;

    public ExameseAmostras(RequestExameseAmostras requestExameseAmostras) {
        this.nomeexame = requestExameseAmostras.nomeexame();
        this.tipo = requestExameseAmostras.tipo();
//        this.dtrealizado = requestExameseAmostras.dtrealizado();
        this.idcliente = requestExameseAmostras.idcliente();
        this.idinforeferencia = requestExameseAmostras.idinforeferencia();
        this.dataHoraColeta = requestExameseAmostras.dataHoraColeta();
        this.nomeProfissional = requestExameseAmostras.nomeProfissional();
        this.numAmostras = requestExameseAmostras.numAmostras();
        this.condicoesColeta = requestExameseAmostras.condicoesColeta();
        this.identificacaoTubos = requestExameseAmostras.identificacaoTubos();
        this.tempoArmazenamento = requestExameseAmostras.tempoArmazenamento();
        this.condicoesTransporte = requestExameseAmostras.condicoesTransporte();
        this.observacoes = requestExameseAmostras.observacoes();
        this.reacoesAdversas = requestExameseAmostras.reacoesAdversas();
        this.acompanhamentoAdicional = requestExameseAmostras.acompanhamentoAdicional();
    }
}
