package pageobject;

import common.LoanAppHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage {

    public AddUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //LOCATORS
    // text field 'Username'
    @FindBy(how = How.NAME, using = "Username")
    private WebElement userName;

    // text field 'Password'
    @FindBy(how = How.NAME, using = "Password")
    private WebElement userPassword;

    // button 'Save'
    @FindBy(how = How.XPATH, using = "//div[5]/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonSave;

    // button 'Cancel'
    @FindBy(how = How.XPATH, using = "//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonCancel;

    // button 'OK' to close warning message
    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]")
    private WebElement buttonOK;

    // METHODS
    public AddUserPage setUserName(WebDriver driver, String username) {
        userName.sendKeys(username);
        return this;
    }

    public AddUserPage setPassword(WebDriver driver, String password) {
        // Enter password
        userPassword.sendKeys(password);
        return this;
    }

    public AddUserPage clickSaveButton(WebDriver driver) {
        // click Save button
        buttonSave.click();
        return this;
    }

    public AddUserPage clickCancelButton(WebDriver driver) {
        // click Cancel button
        buttonCancel.click();
        return this;
    }

    public AddUserPage clickOKButton(WebDriver driver) {
        // click OK  button on warning message pop up
        buttonOK.click();
        return this;
    }

    //METHODS – BOT STYLE

    LoanAppHelper loanAppHelper = new LoanAppHelper();

    public AddUserPage setUsername1(WebDriver driver, String username) {
        // Enter username
        loanAppHelper.setText(driver, "Username", username);
        return this;
    }

    public AddUserPage setPassword1(WebDriver driver, String password) {
        // Enter password
        loanAppHelper.setText(driver, "Password", password);
        return this;
    }

    public AddUserPage clickSaveButton1(WebDriver driver) {
        // click Save button
        loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button");
        return this;
    }

    public AddUserPage clickCancelButton1(WebDriver driver) {
        // click Cancel button
        loanAppHelper.clickElementByXPath(driver, "//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button");
        return this;
    }

    public AddUserPage clickOKButton1(WebDriver driver) {
        // click OK button on warning message pop up
        loanAppHelper.clickElementByXPath(driver, "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]");
        return this;
    }
}
