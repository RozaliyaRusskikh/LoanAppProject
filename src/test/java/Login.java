import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage;

@Test
public class Login {
    public void LMSLogin(WebDriver driver, String branch, String branchAdmin, String branchPassword) {
        //Create Objects required for this test
        LoginPage loginPage = new LoginPage(driver);

        // And now use this to visit LMS login page
        driver.get("http://dev-hitekschool.com/lms/loans/2108");

        // Maximize window
        driver.manage().window().maximize();

        // Read the title of the page and put it into results
        System.out.println("Page title is: " + driver.getTitle());

        //Enter branchName
        loginPage.setBranchName(driver, branch);
        // Enter branch admin username
        loginPage.setBranchAdminUsername(driver, branchAdmin);
        // Enter branch admin password
        loginPage.setBranchAdminPassword(driver, branchPassword);
        // Click Login button
        loginPage.clickLoginButton(driver);

        // Try to sleep (wait) for 10 sec (using exception handler)
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Read the title of the page and put it into results
        System.out.println("Page title is: " + driver.getTitle());
        // Verify the title of the page
        Assert.assertEquals(driver.getTitle(), "Loan Management System - '" + branch + "' branch");
        // close the browser
    }
}
