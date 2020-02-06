package br.com.chrystian.service;

import br.com.chrystian.builder.User;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import static io.restassured.RestAssured.given;

@AllArgsConstructor
public class BaseService {

    public Response createUser(String email, String password) {
        return given()
                .spec(UserRequestSpecification.getRequestSpecification())
                .body(User.builder().email(email).password(password).build())
                .when()
                .post("/register")
                .then()
                .extract().
                        response();
    }
}
