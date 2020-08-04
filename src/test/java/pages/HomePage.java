package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    private By searchBox = By.id("chrome-search");
    private By first = By.cssSelector("[data-auto-id=\"productTile\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String query){
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }

    public void selectFirstItem(){
        driver.findElement(first).click();
    }
}
