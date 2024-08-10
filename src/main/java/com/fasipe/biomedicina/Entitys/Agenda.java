package com.fasipe.biomedicina.Entitys;

import com.fasipe.biomedicina.Users.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "agenda")
@Entity(name = "Agenda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data_consulta")
    private Date dataConsulta;
    @Column(name = "nome_profissional")
    private String nomeProfissional;
    @ManyToOne
    @JoinColumn(name = "id_procedimento", referencedColumnName = "cod")
    private Procedimentos procedimentos;
    @ManyToOne
    @JoinColumn(name = "cpf_paciente", referencedColumnName = "cpfpac")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "id_profissional", referencedColumnName = "codprof")
    private User user;
    @Column(name = "visita")
    private String visita;


    public Agenda(Paciente paciente, Procedimentos procedimentos, User user, Date dataConsulta) {
        this.paciente = paciente;
        this.procedimentos = procedimentos;
        this.user = user;
        this.dataConsulta = dataConsulta;
    }
}