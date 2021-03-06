package eply.com.pageobjects.shop;

import eply.com.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopPage extends BasePage {
    @FindBy(xpath = "/html/body/div[1]/div[2]/header/div[3]/child::*")
    private List<WebElement> barList;
    @FindBy(css = ".menu.transition.visible>a")
    private List<WebElement> dropDownBtn;

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public void chooseCategory(String clothesName, String list) {
        for (WebElement el: barList) {
            if (getText(el).equals(clothesName)) {
                moveTo(el);
                click(el);
                if (!clothesName.equals("Dresses")){
                    sleep(2000);
                    for (WebElement el2: dropDownBtn){
                        if (getText(el2).equals(list)) {
                            moveTo(el2);
                            click(el2);
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
}
