package tests;

import org.example.pageobject.MainPage;
import org.example.pageobject.TrackPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class CheckStatusOrderTest {
    private ChromeDriver driver;

    @Before
    public void startUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void checkOrderStatusNotExistTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.statusOrderButtonClick();
        mainPage.setOrderNumber("NewValue");

        TrackPage trackPage = new TrackPage(driver);
        trackPage.isDisplayedNotFoundOrderImg();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
