package com.fasipe.biomedicina.Entitys;

import com.fasipe.biomedicina.Requests.RequestProcedimentos;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "procedimentos")
@Entity(name = "procedimentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Procedimentos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cod")
    private Integer codProced;
    @Column(name = "descr")
    private String descProced;
    @Column(name = "valor")
    private Double valProced;

    public Procedimentos (RequestProcedimentos requestProcedimentos){
        this.codProced = requestProcedimentos.codProced();
        this.descProced = requestProcedimentos.descProced();
        this.valProced = requestProcedimentos.valProced();
    }

}
