package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }
    public WishListPage getWishListPage() {
        return new WishListPage(driver);
    }
    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }
}
