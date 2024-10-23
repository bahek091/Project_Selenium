package tests;

import org.example.pageobject.MainPage;
import org.example.pageobject.OrderPage;
import org.example.pageobject.TrackPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CheckOrderStatusTest extends BaseUITest {


    @Test
    public void checkOrderStatusNotExistTest(){
        MainPage mainPage = openMainPage(driver);
        mainPage.statusOrderButtonClick();
        mainPage.setOrderNumber("4455");
        mainPage.goButtonClick();

        TrackPage trackPage = new TrackPage(driver);
        Assert.assertTrue(trackPage.isDisplayedNotFoundOrderImg());
    }

}
