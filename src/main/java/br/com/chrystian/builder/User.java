package br.com.chrystian.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    @Builder.Default private String email = "eve.holt@reqres.in";
    @Builder.Default private String password = "password";

}
