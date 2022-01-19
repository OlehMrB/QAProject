package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(@class,'_6iPIuvw _2SSHFPv')]")
    private WebElement registerButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class,'kH5PAAC')]")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@href='https://www.asos.com/saved-lists/?nlid=nav header']")
    private WebElement wishList;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void openHomePage(String url) {
        driver.get(url);
    }
    public void isRegisterButtonVisible() {
        registerButton.isDisplayed();
    }
    public void clickRegistrButton() {
        registerButton.click();
    }
    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }
    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickWishList() {
        wishList.click();
    }
}
