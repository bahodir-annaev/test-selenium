package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ItemPage {
    WebDriver driver;
    Select size;
    By addButton = By.cssSelector("#product-add>.add-item");

    public ItemPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(){
        size = new Select(driver.findElement(By.cssSelector("[data-id=\"sizeSelect\"]")));
        size.selectByIndex(3);
        driver.findElement(addButton).click();
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
