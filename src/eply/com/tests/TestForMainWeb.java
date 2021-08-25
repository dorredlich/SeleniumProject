package eply.com.tests;

import eply.com.pageobjects.MainWebPage;
import eply.com.pageobjects.shop.SelectProduct;
import eply.com.pageobjects.shop.ShopPage;
import eply.com.pageobjects.shop.addToCartPage;
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

        selectProduct.selectProductToBuy("Ribbed copper slim fit Tee");

        addToCartPage cart = new addToCartPage(driver);

        System.out.println("The Price is: " + cart.getPrice());
//        LoginAdminPage ap = new LoginAdminPage(driver);
//        ap.printText();
    }
}
