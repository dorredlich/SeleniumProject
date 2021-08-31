package eply.com.pageobjects.admin;

import eply.com.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(css = "div:nth-child(8) > span")
    private WebElement loginName;
    @FindBy(css = "#customers > tbody > tr > td:nth-child(1) > div")
    private List<WebElement> customersList;
    @FindBy(css = ".ui.labeled.icon.button ")
    private List<WebElement> show;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginName(){
        return getText(loginName);
    }

    public String getListCustomers(){
        int count = 0;
        for (WebElement el: customersList) {
            int count2 = 0;
            if(getText(el).contains("info")) {
                for (WebElement el2: show) {
                    if(count == count2){
                        String email = getText(el);
                        moveTo(el2);
                        click(el2);
                        return email;
                    }
                    count2++;
                }
            }
            count++;
        }
        return null;
    }
}
