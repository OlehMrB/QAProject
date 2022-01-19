package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.charset.StandardCharsets;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'_1336dMe _1uUU2Co _1336dMe _1uUU2Co') and contains(text(),'Sign')]")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[contains(@class,'qa-password-textbox')]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@icontype='accountFilled']")
    private WebElement profileName;

    @FindBy(xpath = "//ul[@class='_12ChTgQ']//a[@data-testid='myaccount-link']")
    private WebElement successProfile;

    @FindBy(xpath = "//span[@class='_3pJ8QYfZUloxmmwdR-XDeK']")
    private WebElement successWelcom;
    public void profileNameVisible() {
        profileName.isEnabled();
    }
    public void clicksubmitButton() {
        submitButton.click();
    }
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void passwordFieldDisplay() {
        passwordField.isDisplayed();
    }
    public void enterpasswordFields(String passwords) {
        passwordField.sendKeys(passwords);
    }

    public void signInButtonClick() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInButton);
    }

    public void successProfileClick() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", successProfile);
    }
    public String getSuccessWelcomText() {
        return successWelcom.getText();
    }

    public void userNameFieldVisible() {
        userNameField.isDisplayed();
    }

    public void enteruserNameField(String name) {
        userNameField.sendKeys(name);
    }
}
