package pageobject;

import common.LoanAppHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    public AddCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // LOCATORS

    @FindBy(how = How.NAME, using = "FirstName")
    private WebElement firstName;

    @FindBy(how = How.NAME, using = "LastName")
    private WebElement lastName;

    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    @FindBy(how = How.XPATH, using = "(//button[@type='button'])[10]")
    private WebElement cancelButton;

    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]")
    private WebElement okButton;

    //METHODS
    public AddCustomerPage setFirstName(WebDriver driver, String firstName2) {
        firstName.sendKeys(firstName2);
        return this;
    }

    public AddCustomerPage setLastName(WebDriver driver, String lastName2) {
        lastName.sendKeys(lastName2);
        return this;
    }

    public AddCustomerPage clickSaveButton(WebDriver driver) {
        saveButton.click();
        return this;
    }

    public AddCustomerPage clickCancelButton(WebDriver driver) {
        cancelButton.click();
        return this;
    }

    public AddCustomerPage clickOKButton(WebDriver driver) {
        okButton.click();
        return this;
    }

    //METHODS - BOT STYLE

    LoanAppHelper loanAppHelper = new LoanAppHelper();

    public AddCustomerPage setFirstName1(WebDriver driver, String firstName2) {
        loanAppHelper.setText(driver, "FirstName", firstName2);
        return this;
    }

    public AddCustomerPage setLastName1(WebDriver driver, String lastName2) {
        loanAppHelper.setText(driver, "LastName", lastName2);
        return this;
    }

    public AddCustomerPage clickSaveButton1(WebDriver driver) {
        loanAppHelper.clickElementByXPath(driver, "//button[normalize-space()='Save']");
        return this;
    }

    public AddCustomerPage clickCancelButton1(WebDriver driver) {
        loanAppHelper.clickElementByXPath(driver, "(//button[@type='button'])[10]");
        return this;
    }

    public AddCustomerPage clickOKButton1(WebDriver driver) {
        loanAppHelper.clickElementByXPath(driver, "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]");
        return this;
    }
}

