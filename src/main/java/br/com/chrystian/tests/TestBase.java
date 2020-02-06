package br.com.chrystian.tests;

import br.com.chrystian.service.UserRequestSpecification;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
public abstract class TestBase {

    public static RequestSpecification requestSpecification;

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = UserRequestSpecification.getRequestSpecification();
    }
}
