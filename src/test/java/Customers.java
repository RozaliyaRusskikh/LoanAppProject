import common.LoanAppHelper;
import dataprovider.CustomerDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pageobject.AddCustomerPage;
import pageobject.CustomersPage;
import pageobject.HomePage;

public class Customers {
    @Test(dataProvider = "CreateCustomer", dataProviderClass = CustomerDataProvider.class)

    public void AddCustomer(String branch, String branchAdmin, String branchPassword, String firstName, String lastName, String warning) {
        // Set GeckoDriver property to interact with Firefow browser
        System.setProperty("webdriver.gecko.driver", "D://geckodriver-v0.29.0-win64/geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // Create a new instance of the firefox driver
        WebDriver driver = new FirefoxDriver();

        int numberOFMilliseconds = 5000;

        // Create instances
        Login login = new Login();
        CustomersPage customersPage = new CustomersPage(driver);
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        HomePage homePage = new HomePage(driver);
        LoanAppHelper loanAppHelper = new LoanAppHelper();

        // Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
        login.LMSLogin(driver, branch, branchAdmin, branchPassword);

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);
        // Click button 'Customers'
        homePage.clickCustomersButton(driver);

        // Click button 'Actions'
        customersPage.clickActionsButton(driver);

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // Click menu item 'Add Customer' by link text
        customersPage.clickAddCustomer(driver);

        // Enter FirstName
        addCustomerPage.setFirstName(driver, firstName);

        //Enter lastName
        addCustomerPage.setLastName(driver, lastName);

        // Click button 'Save' by its xpath
        addCustomerPage.clickSaveButton(driver);

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        if (warning != "") {
            loanAppHelper.doesTextExistOnPage(warning, driver);
            // find button ok by xpath and click it to close pop up
            addCustomerPage.clickOKButton(driver);
            // Click button 'Cancel' by its xpath
            addCustomerPage.clickCancelButton(driver);
        } else {
            // verify the results by parsing html page and making sure it contain just created username
            loanAppHelper.doesTextExistOnPage(lastName, driver);
        }
        // Click button 'Logout' by its xpath
        customersPage.clickLogoutButton(driver);

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // close the browser
        driver.close();
    }

    @Test(dataProvider = "CreateCustomer", dataProviderClass = CustomerDataProvider.class)

    public void AddCustomer1(String branch, String branchAdmin, String branchPassword, String firstName, String lastName, String warning) {
        // Set GeckoDriver property to interact with Firefow browser
        System.setProperty("webdriver.gecko.driver", "D://geckodriver-v0.29.0-win64/geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // Create a new instance of the firefox driver
        WebDriver driver = new FirefoxDriver();

        int numberOFMilliseconds = 5000;

        // Create instances
        Login login = new Login();
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        LoanAppHelper loanAppHelper = new LoanAppHelper();

        // Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
        login.LMSLogin(driver, branch, branchAdmin, branchPassword);

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);
        // Click button 'Customers'
        loanAppHelper.clickElementByID(driver, "ext-gen192");

        // Click button 'Actions'
        loanAppHelper.clickElementByXPath(driver, "//td[1]/table//button[@type='button']");

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // Click menu item 'Add Customer' by link text
        loanAppHelper.clickElementByLinkName(driver, "Add Customer");

        // Enter FirstName
        addCustomerPage.setFirstName1(driver, firstName);

        //Enter lastName
        addCustomerPage.setLastName1(driver, lastName);

        // Click button 'Save' by its xpath
        addCustomerPage.clickSaveButton1(driver);

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        if (warning != "") {
            loanAppHelper.doesTextExistOnPage(warning, driver);
            // find button ok by xpath and click it to close pop up
            addCustomerPage.clickOKButton1(driver);
            // Click button 'Cancel' by its xpath
            addCustomerPage.clickCancelButton1(driver);
        } else {
            // verify the results by parsing html page and making sure it contain just created username
            loanAppHelper.doesTextExistOnPage(lastName, driver);
        }
        // Click button 'Logout' by its xpath
        loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button");

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // close the browser
        driver.close();
    }
}
