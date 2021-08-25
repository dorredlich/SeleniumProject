package eply.com.pageobjects.shop;

import eply.com.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectProduct extends BasePage {

    @FindBy(css = ".ui.negative.icon.labeled.button")
    private WebElement clearBtn;

    public SelectProduct(WebDriver driver) {
        super(driver);
    }

    public String getTextClear(){
       return getText(clearBtn);
    }

}
