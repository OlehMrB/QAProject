package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage{
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='progressIndicatorWrapper_3QQxZ']")
    private List<WebElement> wishList;

    public Integer getwishListCount(){
        System.out.println(wishList.size());
        return wishList.size();
    }
}
