package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //this is a constructor
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // LOCATORS
    // initialize Page class elements without using "FindElement/s."
    // text field 'branch name'
    @FindBy(how = How.NAME, using = "j_branch")
    private WebElement branchName;

    // text field 'branch admin username'
    @FindBy(how = How.NAME, using = "j_username")
    private WebElement branchAdminUsername;

    // text field 'branch name'
    @FindBy(how = How.NAME, using = "j_password")
    private WebElement branchAdminPassword;

    // button 'Login'
    @FindBy(how = How.ID, using = "ext-gen38")
    private WebElement buttonLogin;

    //METHODS

    public LoginPage setBranchName(WebDriver driver, String branch) {
        // Find the text input element 'branch' by its name
        // Enter username
        branchName.sendKeys(branch);
        return this;
    }

    public LoginPage setBranchAdminUsername(WebDriver driver, String branchAdmin) {
        // Find the text input element 'username' by its name
        // Enter username
        branchAdminUsername.sendKeys(branchAdmin);
        return this;
    }

    public LoginPage setBranchAdminPassword(WebDriver driver, String branchPassword) {
        // Find the text input element 'password' by its name
        // Enter password
        branchAdminPassword.sendKeys(branchPassword);
        return this;
    }

    public LoginPage clickLoginButton(WebDriver driver) {
        // Find the button Login by its id
        // Click Login button
        buttonLogin.click();
        return this;
    }


}
