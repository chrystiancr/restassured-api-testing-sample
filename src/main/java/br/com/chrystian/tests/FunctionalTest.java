package br.com.chrystian.tests;

import br.com.chrystian.builder.User;
import br.com.chrystian.datadriven.UserDataProvider;
import br.com.chrystian.service.BaseService;
import br.com.chrystian.utils.DefaultValues;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class FunctionalTest extends TestBase {

    @Test(groups = "functional", dataProvider = "invalidUserDataProvider", dataProviderClass = UserDataProvider.class)
    public void invalidUserTest(User user) {

        BaseService baseService = new BaseService();

        Response createUser = baseService.createUser(user.getEmail(), user.getPassword());

        assertThat(createUser.statusCode(), is(HttpStatus.SC_BAD_REQUEST));
        Assert.assertEquals(createUser.jsonPath().get("error"), DefaultValues.UNAUTHORIZED_USER);

    }
}
