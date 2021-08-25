package eply.com.pageobjects.shop;

import eply.com.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addToCartPage extends BasePage {

    @FindBy(css = "#product-price")
    private WebElement price;

    public addToCartPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice(){
        return getText(price);
    }
}
