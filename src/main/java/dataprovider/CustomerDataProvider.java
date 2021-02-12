package dataprovider;

import org.testng.annotations.DataProvider;

/**
 * Created with IntelliJ IDEA.
 * User: rr
 * Date: 2/8/21
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDataProvider {
    @DataProvider(name = "CreateCustomer")
    public static Object[][] createCustomer() // there are 2 square brackets [] [] after word Object
    {
        return new Object[][]{
                {"Kelowna", "admin", "rrusskikh1019", "julia", "roberts", ""},
                {"Kelowna", "admin", "rrusskikh1019", "", "roberts", "Mandatory field 'First Name' is empty"},
                {"Kelowna", "admin", "rrusskikh1019", "juliia", "", "Mandatory field 'Last Name' is empty"}

        };
    }
}
