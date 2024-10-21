package tests;

import org.example.pageobject.MainPage;
import org.example.pageobject.TrackPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class CheckStatusOrderTest extends BaseUITest{

    @Test
    public void checkOrderStatusNotExistTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.cookieButtonClick();
        mainPage.statusOrderButtonClick();
        mainPage.setOrderNumber("NewValue");

        TrackPage trackPage = new TrackPage(driver);
        Assert.assertTrue(trackPage.isDisplayedNotFoundOrderImg());

    }


}
