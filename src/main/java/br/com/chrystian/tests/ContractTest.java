package br.com.chrystian.tests;

import br.com.chrystian.utils.DefaultValues;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ContractTest extends TestBase {

    @Test(groups = "contract")
    public void checkContractTest() {

        given()
                .spec(requestSpecification)
                .when()
                .get("/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(DefaultValues.JSON_SCHEMA_PATH + "response-user.json")));
    }

}
