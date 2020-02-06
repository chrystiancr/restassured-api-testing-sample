package br.com.chrystian.datafactory;

import br.com.chrystian.builder.User;

public class UserDataFactory {

    public User returnNewUser() {
        return User.
                builder()
                .email("eve.holt@reqres.in")
                .password("password")
                .build();
    }

    public User returnInvalidUser() {
        return User.
                builder()
                .email("e@mail.com")
                .password("12345")
                .build();
    }
}
