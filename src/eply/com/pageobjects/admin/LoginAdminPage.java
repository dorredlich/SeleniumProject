package eply.com.pageobjects.admin;

import eply.com.pageobjects.MainWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAdminPage extends MainWebPage {
    @FindBy(css = "body > div > div > form > div > div.ui.icon.info.message > div > p")
    private WebElement userNameText;
    @FindBy(css = "#_username")
    private WebElement userName;
    @FindBy(css = ".content > p > br")
    private WebElement password;
    @FindBy(css = "")
    private WebElement loginBtn;
    public LoginAdminPage(WebDriver driver) {
        super(driver);
    }

    public void printText(){
        String text = getText(userNameText);
        String split[] = text.split("\\n");
        String[] text1 = new String[4];
        for (String s: split) {
            text1 = s.split(":");
        }
        System.out.print(text1[1]);
        //fillText(userName, s);
    }
}
