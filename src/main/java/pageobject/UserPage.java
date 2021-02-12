package pageobject;

import common.LoanAppHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

    // this is a constructor
    public UserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    // LOCATORS

    // button 'Actions'
    @FindBy(how = How.XPATH, using = "//td[1]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonActions;

    // link 'Add User'
    @FindBy(how = How.LINK_TEXT, using = "Add User")
    private WebElement linkAddUser;

    // link 'Edit User'
    @FindBy(how = How.LINK_TEXT, using = "Edit User")
    private WebElement linkEditUser;

    // link 'Delete User'
    @FindBy(how = How.LINK_TEXT, using = "Delete User")
    private WebElement linkDeleteUser;

    // button 'Logout'
    @FindBy(how = How.XPATH, using = "//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonLogout;


    // METHODS

    public UserPage clickActionsButton(WebDriver driver) {
        // click Users button
        buttonActions.click();
        return this;
    }

    public UserPage clickAddUserLink(WebDriver driver) {
        // click Add User link
        linkAddUser.click();
        return this;
    }

    public UserPage clickEditUserLink(WebDriver driver) {
        // click Edit User link
        linkEditUser.click();
        return this;
    }

    public UserPage clickDeleteUserLink(WebDriver driver) {
        // click Delete User link
        linkDeleteUser.click();
        return this;
    }

    public UserPage clickLogoutButton(WebDriver driver) {
        // click Logout button
        buttonLogout.click();
        return this;
    }

    // METHODS - BOT STYLE
    LoanAppHelper loanAppHelper = new LoanAppHelper();

    public UserPage clickActionsButton1(WebDriver driver) {
        // click Users button
        loanAppHelper.clickElementByXPath(driver, "//td[1]/table/tbody/tr/td[2]/em/button");
        return this;
    }

    public UserPage clickAddUserLink1(WebDriver driver) {
        // click Add User link
        loanAppHelper.clickElementByLinkName(driver, "Add User");
        return this;
    }

    public UserPage clickEditUserLink1(WebDriver driver) {
        // click Edit User link
        loanAppHelper.clickElementByLinkName(driver, "Edit User");
        return this;
    }

    public UserPage clickDeleteUserLink1(WebDriver driver) {
        // click Delete User link
        loanAppHelper.clickElementByLinkName(driver, "Delete User");
        return this;
    }

    public UserPage clickLogoutButton1(WebDriver driver) {
        // click Logout button
        loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button");
        return this;
    }

}