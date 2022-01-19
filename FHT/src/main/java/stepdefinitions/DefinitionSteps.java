package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;
import pages.WishListPage;
import static org.junit.Assert.assertEquals;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    PageFactoryManager pageFactoryManager;
    LoginPage loginPage;
    SearchResultsPage searchResultsPage;
    WishListPage wishListPage;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }


    @And("User checks profiles button visibility")
    public void userChecksProfilesButtonVisibility() {
        homePage.isRegisterButtonVisible();
    }

    @And("User clicks SignIn")
    public void userClicksSignIn() {

        homePage.clickRegistrButton();
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.signInButtonClick();
    }

    @And("User checks email address field visibility")
    public void userChecksEmailAddressFieldVisibility() {
        loginPage.userNameFieldVisible();
    }

    @When("User fills email address {string}")
    public void userFillsEmailAddressLogins( String name) {
        loginPage.enteruserNameField(name);
    }

    @And("User checks password field visibility")
    public void userChecksPasswordFieldVisibility() {
        loginPage.passwordFieldDisplay();
    }

    @When("User fills password field {string}")
    public void userFillsPasswordFieldPasswords(String passwords) {
        loginPage.enterpasswordFields(passwords);
    }

    @And("User clicks SignIn button")
    public void userClicksSignInButton() {
        loginPage.clicksubmitButton();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User clicks wish list on first product")
    public void userClicksWishListOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickWishListonFirstProduct();
    }

    @Then("User checks that amount of products in wish list are {string}")
    public void userChecksThatAmountOfProductsInWishListAreAmountOfProducts(final String expectedAmount) {
        homePage.clickWishList();
        wishListPage = pageFactoryManager.getWishListPage();
        Integer col = Integer.parseInt(expectedAmount);
        assertEquals(wishListPage.getwishListCount(), col);
    }

    @Then("User checks yours fill profileName {string} in profile")
    public void userChecksYoursFillProfileNameSuccessWelcomeInProfile(final String welcomText) throws InterruptedException {
        sleep(4000);// по другому не смог придумать как обойти
        homePage.clickRegistrButton();
        sleep(2000);//по другому не смог придумать как обойти
        loginPage.successProfileClick();
        sleep(4000);//по другому не смог придумать как обойти
        assertEquals(loginPage.getSuccessWelcomText(),welcomText);
    }
}
