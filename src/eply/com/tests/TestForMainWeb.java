package eply.com.tests;

import eply.com.pageobjects.MainWebPage;
import eply.com.pageobjects.shop.SelectProduct;
import eply.com.pageobjects.shop.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TestForMainWeb extends BaseTest{


    @Test
    public void test1(){
        driver.get("https://sylius.com/try/");

        MainWebPage wp = new MainWebPage(driver);
        wp.getShopePage();

        String main = driver.getWindowHandle();

        Set<String> list =  driver.getWindowHandles();
        for (String win: list) {
            driver.switchTo().window(win);
        }
        ShopPage sp = new ShopPage(driver);
        sp.chooseCategory("T-shirts", "Women");

        SelectProduct selectProduct = new SelectProduct(driver);
        String text = selectProduct.getTextClear();
        Assert.assertEquals(text, "Clear");
//        LoginAdminPage ap = new LoginAdminPage(driver);
//        ap.printText();
    }
}
