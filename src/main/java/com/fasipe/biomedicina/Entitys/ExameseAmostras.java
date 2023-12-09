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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomexame")
    private String nomeexame;
    @Column(name = "tipo")
    private Boolean tipo;
    @Column(name = "dtrealizado")
    private Date dtrealizado;
//    @ManyToOne
//    @JoinColumn(name = "idcliente")
    @Column(name = "idcliente")
    private Long idcliente;
//    @ManyToOne
//    @JoinColumn(name = "idinforeferencia")
    @Column(name = "idinforeferencia")
    private Long idinforeferencia;
    public ExameseAmostras(RequestExameseAmostras requestExameseAmostras){
        this.nomeexame = requestExameseAmostras.nomeexame();
        this.tipo = requestExameseAmostras.tipo();
        this.dtrealizado = requestExameseAmostras.dtrealizado();
        this.idcliente = requestExameseAmostras.idcliente();
        this.idinforeferencia = requestExameseAmostras.idinforeferencia();
    }
}
