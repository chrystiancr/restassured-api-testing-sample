package br.com.chrystian.tests;

import br.com.chrystian.builder.User;
import br.com.chrystian.datadriven.UserDataProvider;
import br.com.chrystian.service.BaseService;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class AcceptanceTest extends TestBase {

    @Test(groups = "acceptance", dataProvider = "userDataProvider", dataProviderClass = UserDataProvider.class)
    public void testCheckRegistration(User user) {

        BaseService baseService = new BaseService();

        Response createUser = baseService.createUser(user.getEmail(), user.getPassword());

        assertEquals(createUser.statusCode(), SC_OK);
        assertNotNull(createUser.body());

    }

}
