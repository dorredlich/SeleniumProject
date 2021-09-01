package eply.com;

import eply.com.BaseTest;
import eply.com.pageobjects.MainWebPage;
import eply.com.pageobjects.admin.DashboardPage;
import eply.com.pageobjects.admin.LoginAdminPage;
import eply.com.pageobjects.shop.SelectProduct;
import eply.com.pageobjects.shop.ShopPage;
import eply.com.pageobjects.shop.addToCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TestForMainWeb extends BaseTest {


    @Test
    public void test_shopPage(){
        driver.get("https://sylius.com/try/");

        MainWebPage wp = new MainWebPage(driver);
        wp.getShopePage();

        String main = driver.getWindowHandle();

        Set<String> list =  driver.getWindowHandles();
        for (String win: list) {
            driver.switchTo().window(win);
        }
        ShopPage sp = new ShopPage(driver);
        sp.chooseCategory("Caps", "Simple");

        SelectProduct selectProduct = new SelectProduct(driver);
        String text = selectProduct.getTextClear();
        Assert.assertEquals(text, "Clear");

        selectProduct.selectProductToBuy("Cashmere-blend violet beanie");

        addToCartPage cart = new addToCartPage(driver);

        System.out.println("The Price is: " + cart.getPrice());

    }

    @Test
    public void test_adminPage(){
        driver.get("https://sylius.com/try/");

        MainWebPage wp = new MainWebPage(driver);
        wp.getToAdminPage();

        String main = driver.getWindowHandle();

        Set<String> list =  driver.getWindowHandles();
        for (String win: list) {
            driver.switchTo().window(win);
        }

        LoginAdminPage loginAdminPage = new LoginAdminPage(driver);
        loginAdminPage.login("sylius@example.com", "sylius");

        DashboardPage dashboardPage = new DashboardPage(driver);
        String loginName = dashboardPage.getLoginName();
        Assert.assertEquals(loginName, "John");
        String email = dashboardPage.getListCustomers();
        System.out.println(email);
    }
}
