package br.com.chrystian.tests;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static br.com.chrystian.service.UserRequestSpecification.getRequestSpecification;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class HealthCheckTest extends TestBase {

    @Test(groups = "healthCheck")
    public void healthCheckTest() {

        given().
                spec(getRequestSpecification()).
                when().
                get("/users/2").
                then().
                statusCode(SC_OK);
    }

}
