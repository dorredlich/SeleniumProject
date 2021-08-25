package eply.com.pageobjects.shop;

import eply.com.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SelectProduct extends BasePage {

    @FindBy(css = ".ui.negative.icon.labeled.button")
    private WebElement clearBtn;
    @FindBy(css = "a.header.sylius-product-name")
    private List<WebElement> productList;

    public SelectProduct(WebDriver driver) {
        super(driver);
    }

    public String getTextClear(){
       return getText(clearBtn);
    }

    public void selectProductToBuy(String productName){
        for (WebElement el: productList) {
            if (getText(el).equals(productName)){
                System.out.println("text: " + getText(el));
                System.out.println("text2: " + productName);
                sleep(1000);
                moveTo(el);
                sleep(2000);
                click(el);
                sleep(1000);
                break;
            }
        }
    }
}
