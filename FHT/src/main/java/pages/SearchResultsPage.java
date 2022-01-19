package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//button[@class='_2HTnAzH M3dcC1z']")
    private List<WebElement> wishListButton;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWishListonFirstProduct() {
        wishListButton.get(0).click();
    }
}
