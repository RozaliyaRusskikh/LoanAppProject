import common.LoanAppHelper;
import dataprovider.UserDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pageobject.AddUserPage;
import pageobject.HomePage;
import pageobject.UserPage;

public class Users {
    @Test(dataProvider = "CreateUser", dataProviderClass = UserDataProvider.class)
    // @Parameters(value = {"branch", "branchAdmin","branchPassword", "user", "password"})

    public void AddUser(String branch, String branchAdmin, String branchPassword, String user, String password, String warning) {
        // Set GeckoDriver property to interact with Firefow browser
        System.setProperty("webdriver.gecko.driver", "D://geckodriver-v0.29.0-win64/geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // Create a new instance of the firefox driver
        WebDriver driver = new FirefoxDriver();

        int numberOFMilliseconds = 5000;

        //Create Objects required for this test
        Login login = new Login();
        HomePage homePage = new HomePage(driver);
        UserPage usersPage = new UserPage(driver);
        AddUserPage addUserPage = new AddUserPage(driver);
        LoanAppHelper loanAppHelper = new LoanAppHelper();

        // Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
        login.LMSLogin(driver, branch, branchAdmin, branchPassword);

        // Click button 'Users'
        homePage.clickUsersButton(driver);

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);
        // Click button 'Actions'
        usersPage.clickActionsButton(driver);

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);
        // Click 'Add User' link
        usersPage.clickAddUserLink(driver);

        // Enter Username
        addUserPage.setUserName(driver, user);

        //Enter Password
        addUserPage.setPassword(driver, password);

        // Click button 'Save'
        addUserPage.clickSaveButton(driver);

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        if (warning != "") {
            loanAppHelper.doesTextExistOnPage(warning, driver);

            // click ok button to close the pop up
            addUserPage.clickOKButton(driver);
            // Click 'Cancel' button
            addUserPage.clickCancelButton(driver);
        } else {
            // verify the results by parsing html page and making sure it contain just created username
            loanAppHelper.doesTextExistOnPage(user, driver);
        }
        // Click button 'Logout' by its xpath
        usersPage.clickLogoutButton(driver);

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // close the browser
        driver.close();
    }

    @Test(dataProvider = "CreateUser", dataProviderClass = UserDataProvider.class)
    // @Parameters(value = {"branch", "branchAdmin","branchPassword", "user", "password"})
    public void AddUser1(String branch, String branchAdmin, String branchPassword, String user, String password, String warning) {
        // Set GeckoDriver property to interact with Firefow browser
        System.setProperty("webdriver.gecko.driver", "D://geckodriver-v0.29.0-win64/geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // Create a new instance of the firefox driver
        WebDriver driver = new FirefoxDriver();

        int numberOFMilliseconds = 5000;

        //Create Objects required for this test
        Login login = new Login();
        /*HomePage homePage = new HomePage(driver);
        UserPage usersPage = new UserPage(driver);
        AddUserPage addUserPage = new AddUserPage(driver);*/
        LoanAppHelper loanAppHelper = new LoanAppHelper();

        // Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
        login.LMSLogin(driver, branch, branchAdmin, branchPassword);

        // Click button 'Users'
        loanAppHelper.clickElementByID(driver, "ext-gen185");

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);
        // Click button 'Actions'
        loanAppHelper.clickElementByXPath(driver, "//td[1]/table/tbody/tr/td[2]/em/button");

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);
        // Click 'Add User' link
        loanAppHelper.clickElementByLinkName(driver, "Add User");

        // Enter Username
        loanAppHelper.setText(driver, "Username", user);

        //Enter Password
        loanAppHelper.setText(driver, "Password", password);

        // Click button 'Save'
        loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button");

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        if (warning != "") {
            loanAppHelper.doesTextExistOnPage(warning, driver);

            // click ok button to close the pop up
            loanAppHelper.clickElementByXPath(driver, "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]");
            // Click 'Cancel' button
            loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button");
        } else {
            // verify the results by parsing html page and making sure it contain just created username
            loanAppHelper.doesTextExistOnPage(user, driver);
        }
        // Click button 'Logout' by its xpath
        loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button");

        // try to sleep (wait) for 5 sec (using exception handler)
        loanAppHelper.sleep(numberOFMilliseconds);

        // close the browser
        driver.close();
    }
}
