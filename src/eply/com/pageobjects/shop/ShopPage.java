package eply.com.pageobjects.shop;

import eply.com.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopPage extends BasePage {
    @FindBy(xpath = "/html/body/div[1]/div[2]/header/div[3]/child::*")
    private List<WebElement> barList;
//    @FindBy(css = ".sixteen.wide.tablet.eight.wide.computer.column > .ui.two.cards > .ui.fluid.card > .content > .header.sylius-product-name")
//    private List<WebElement> ClothesList;
//    @FindBy(css = ".sixteen.wide.tablet.eight.wide.computer.column > .ui.two.cards> .ui.fluid.card >.blurring.dimmable.image")
//    private WebElement move;
//    @FindBy(css = ".sixteen.wide.tablet.eight.wide.computer.column>.ui.two.cards>.ui.fluid.card >.blurring.dimmable.image.dimmed>.ui.dimmer.transition.visible.active>.content>.center>.ui.inverted.button")
//    private WebElement viewBtn;
    @FindBy(css = ".menu.transition.visible>a")
    private List<WebElement> dropDownBtn;

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public void chooseCategory(String clothesName, String list) {
        System.out.println("size: " + barList.size());
        for (int i = 0; i < barList.size(); i++) {
            System.out.println("test: " + getText(barList.get(i)));
            if (getText(barList.get(i)).equals(clothesName)) {
                System.out.println("Text2: " + barList.get(i));
                sleep(2000);
                moveTo(barList.get(i));
                sleep(1000);
                click(barList.get(i));
                if (!clothesName.equals("Dresses")){
                    sleep(2000);
                    for (int j = 0; j < dropDownBtn.size(); i++){
                        System.out.println("size: " + dropDownBtn.size());
                        System.out.println("Text: " + dropDownBtn.get(i).getText());
                        if (getText(dropDownBtn.get(i)).equals(list)) {
                            System.out.println("size2: " + dropDownBtn.size());
                            sleep(2000);
                            moveTo(dropDownBtn.get(i));
                            sleep(1000);
                            click(dropDownBtn.get(i));
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
}
