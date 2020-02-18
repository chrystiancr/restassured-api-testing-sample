package br.com.chrystian.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static br.com.chrystian.utils.PropertyLoader.getBasePath;
import static br.com.chrystian.utils.PropertyLoader.getBaseURI;

public class UserRequestSpecification {

    private static final String BASE_URI = getBaseURI();
    private static final String BASE_PATH = getBasePath();

    public static RequestSpecification getRequestSpecification() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        return new RequestSpecBuilder()
                .setConfig(
                        new RestAssuredConfig()
                                .sslConfig(
                                        new SSLConfig().relaxedHTTPSValidation()
                                )
                ).setRelaxedHTTPSValidation()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI)
                .setBasePath(BASE_PATH)
                .log(LogDetail.ALL)
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

}
