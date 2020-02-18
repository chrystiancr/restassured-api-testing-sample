package br.com.chrystian.tests;

import br.com.chrystian.builder.User;
import br.com.chrystian.datadriven.UserDataProvider;
import br.com.chrystian.service.BaseService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static br.com.chrystian.utils.DefaultValues.UNAUTHORIZED_USER;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FunctionalTest extends TestBase {

    @Test(groups = "functional", dataProvider = "invalidUserDataProvider", dataProviderClass = UserDataProvider.class)
    public void invalidUserTest(User user) {

        BaseService baseService = new BaseService();

        Response createUser = baseService.createUser(user.getEmail(), user.getPassword());

        assertThat(createUser.statusCode(), is(SC_BAD_REQUEST));
        Assert.assertEquals(createUser.jsonPath().get("error"), UNAUTHORIZED_USER);

    }
}
