package br.com.chrystian.tests;

import br.com.chrystian.utils.DefaultValues;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

import static br.com.chrystian.service.UserRequestSpecification.getRequestSpecification;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ContractTest extends TestBase {

    @Test(groups = "contract")
    public void checkContractTest() {

        given()
                .spec(getRequestSpecification())
                .when()
                .get("/users/2")
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(DefaultValues.JSON_SCHEMA_PATH + "response-user.json")));
    }

}
