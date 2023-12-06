package com.fasipe.biomedicina.Entitys;

import com.fasipe.biomedicina.Users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "agenda")
@Entity(name = "agenda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idagenda")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cpfcliente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idprocedimento")
    private Procedimentos procedimentos;

    @ManyToOne
    @JoinColumn(name = "idprofissional")
    private User user;
    @Column(name = "Dtabertura")
    private Date dataConsulta;



    // Outros atributos e métodos da classe Agenda...

    public Agenda(Paciente paciente, Procedimentos procedimentos, User user, Date dataConsulta) {
        this.paciente = paciente;
        this.procedimentos = procedimentos;
        this.user = user;
        this.dataConsulta = dataConsulta;

    }
}