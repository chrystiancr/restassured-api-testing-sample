package br.com.chrystian.tests;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HealthCheckTest extends TestBase {

    @Test(groups = "healthCheck")
    public void healthCheckTest() {

        given().
                spec(requestSpecification).
                when().
                get("/users/2").
                then().
                statusCode(HttpStatus.SC_OK);
    }

}
