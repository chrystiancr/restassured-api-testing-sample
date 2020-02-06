package br.com.chrystian.service;

import br.com.chrystian.utils.PropertyLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class UserRequestSpecification {

    private static final String BASEURI = PropertyLoader.Service.BASEURI.getValue();
    private static final String BASEPATH = PropertyLoader.Service.BASEPATH.getValue();

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setConfig(
                        new RestAssuredConfig()
                                .sslConfig(
                                        new SSLConfig().relaxedHTTPSValidation()
                                )
                ).setRelaxedHTTPSValidation()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASEURI)
                .setBasePath(BASEPATH)
                .log(LogDetail.ALL)
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

}
