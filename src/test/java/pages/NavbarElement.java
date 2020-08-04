package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NavbarElement {
    WebDriver driver;

    NavbarElement(WebDriver driver){
        this.driver = driver;
    }

    public void openCartPage() throws InterruptedException{
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("miniBagDropdown"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[data-test-id=\"bag-link\"]")).click();
    }
}
