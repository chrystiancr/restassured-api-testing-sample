package br.com.chrystian.datadriven;

import br.com.chrystian.datafactory.UserDataFactory;
import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "userDataProvider")
    public Object[] userDataProvider() {
        return new Object[]{
                new UserDataFactory().returnNewUser()
        };
    }

    @DataProvider(name = "invalidUserDataProvider")
    public Object[] invalidUserDataProvider() {
        return new Object[]{
                new UserDataFactory().returnInvalidUser()
        };
    }

}
