import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import pages.HomePage;
import pages.ItemPage;
import pages.CartPage;

public class TestCart {
    private WebDriver driver;
    HomePage homePage;
    ItemPage itemPage;
    CartPage cartPage;

    @BeforeTest
    public void init(){
        System.setProperty("webdriver.chrome.driver","C:\\chrome84\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("https://www.asos.com/");
    }

    @AfterTest
    public void close(){
        driver.quit();
    }

    @Test
    public void test1(){
        homePage = new HomePage(driver);
        homePage.searchItem("boots");
        homePage.selectFirstItem();

        itemPage = new ItemPage(driver);
        itemPage.addToCart();

        driver.get("https://www.asos.com/bag");

        cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getItemsCount(), 1);

        cartPage.removeFirstItem();
        Assert.assertEquals(cartPage.getItemsCount(), 0);
    }
}
