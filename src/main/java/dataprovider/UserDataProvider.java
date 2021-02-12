package dataprovider;

import org.testng.annotations.DataProvider;

/**
 * Created with IntelliJ IDEA.
 * User: rr
 * Date: 2/8/21
 * Time: 9:49
 * To change this template use File | Settings | File Templates.
 */
public class UserDataProvider {
    @DataProvider(name = "CreateUser")
    public static Object[][] CreateUser() // there are 2 square brackets [] [] after word Object
    {
        return new Object[][]{
                {"Kelowna", "admin", "rrusskikh1019", "bsample", "password", ""},
                {"Kelowna", "admin", "rrusskikh1019", "", "password", "Mandatory field 'Username' is empty"},
                {"Kelowna", "admin", "rrusskikh1019", "bsample", "", "Mandatory field 'Password' is empty"}

        };
    }
}