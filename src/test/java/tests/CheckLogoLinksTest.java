package tests;


import org.example.pageobject.MainPage;
import org.example.pageobject.OrderPage;
import org.junit.Assert;
import org.junit.Test;

public class CheckLogoLinksTest extends BaseUITest{

    @Test
    public void shouldOpenYandexPageOnYandexLogoClick(){
        OrderPage orderPage = new OrderPage(driver);
        orderPage.openOrderPage();
        orderPage.clickYandexLogo();
        driver.switchTo();
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        Assert.assertTrue(OrderPage.YANDEX_URL.equals(driver.getCurrentUrl()));
    }

    @Test
    public void shouldOpenMainPageOnSamokatLogoClick(){
        OrderPage orderPage = new OrderPage(driver);
        orderPage.openOrderPage();
        orderPage.clickSamokatLogo();

        Assert.assertTrue(MainPage.MAIN_PAGE_URL.equals(driver.getCurrentUrl()));
    }
}
