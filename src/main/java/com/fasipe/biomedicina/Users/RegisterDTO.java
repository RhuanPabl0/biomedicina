package com.fasipe.biomedicina.Users;

public record RegisterDTO(
        String nome,
        String login,
        String password,
        UserRole role,
        Integer sup,
        Integer status,
        String cons
        ) {
}
