package br.com.chrystian.datadriven;

import br.com.chrystian.builder.User;
import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "userDataProvider")
    public Object[] userDataProvider() {
        return new Object[]{
                new User().builder().build(),
        };
    }

    @DataProvider(name = "invalidUserDataProvider")
    public Object[] invalidUserDataProvider() {
        return new Object[]{
                new User().builder().email("e@mail.com").password("12345").build(),
        };
    }

}
