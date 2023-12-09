package com.fasipe.biomedicina.Entitys;


import com.fasipe.biomedicina.Requests.RequestInfoRefencia;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "inforeferencia")
@Entity(name = "inforeferencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class InfoReferencia {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idprocedimento")
    private Procedimentos procedimentos;
    @Column(name = "referencia_min")
    private Double referenciamin;
    @Column(name = "referencia_max")
    private Double referenciamax;
    @Column(name = "medida")
    private String medida;

    public InfoReferencia(RequestInfoRefencia requestInfoRefencia){
        this.procedimentos = requestInfoRefencia.procedimentos();
        this.referenciamin = requestInfoRefencia.referenciamin();
        this.referenciamax = requestInfoRefencia.referenciamax();
        this.medida = requestInfoRefencia.medida();
    }
}
