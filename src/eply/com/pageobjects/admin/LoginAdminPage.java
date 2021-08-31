package eply.com.pageobjects.admin;

import eply.com.pageobjects.MainWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAdminPage extends MainWebPage {

    @FindBy(css = "#_username")
    private WebElement userName;
    @FindBy(css = "#_password")
    private WebElement password;
    @FindBy(css = "[type='submit']")
    private WebElement loginBtn;

    public LoginAdminPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userNameS, String passwordS){
        fillText(userName, userNameS);
        fillText(password, passwordS);
        click(loginBtn);
    }
}
