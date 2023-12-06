package com.fasipe.biomedicina.Users;

public record RegisterDTO(
        String login,
        String password,
        UserRole role,
        Integer sup,
        Integer status,
        String cons
        ) {
}
