package eply.com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainWebPage extends BasePage{
    @FindBy(css = ".pb-4.mb-4.border-bottom>div:nth-child(1) >span.text-lead")
    private WebElement adminUserName;
    @FindBy(css = "[href='https://demo.sylius.com/admin']")
    private WebElement adminDemoBtn;
    @FindBy(css = "[href='https://demo.sylius.com/']")
    private WebElement shopDemoBtn;

    public MainWebPage(WebDriver driver) {
        super(driver);
    }

    public void getToAdminPage(){
        click(adminDemoBtn);
    }

    public void getShopePage(){
        click(shopDemoBtn);
    }

}
