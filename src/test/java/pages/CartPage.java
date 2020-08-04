package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By items = By.className("bag-item-holder");
    By removeButton = By.cssSelector("bag-remove button");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public int getItemsCount(){
        return driver.findElements(items).size();
    }

    public void removeFirstItem(){
        driver.findElement(removeButton).click();
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
