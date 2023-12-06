package com.fasipe.biomedicina.Users;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "profissional")
@Table(name = "profissional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codprof")
    private Long id;
    @Column(name = "nomeprof")
    private String login;
    @Column(name = "senha")
    private String password;
    @Column(name = "tipoprof")
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Column(name = "supprof")
    private Integer sup;
    @Column(name = "statusprof")
    private  Integer status;
    @Column(name = "consprof")
    private  String cons;

    public User(String login, String password, UserRole role, Integer sup,Integer status, String cons){
        this.login = login;
        this.password = password;
        this.role = role;
        this.sup = sup;
        this.status = status;
        this.cons = cons;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return login;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }


}
