package com.fasipe.biomedicina.Repositorys;

import com.fasipe.biomedicina.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
    User findByLoginIgnoreCase(String login); // Adicione esta linha para buscar por login, ignorando maiúsculas/minúsculas
}
