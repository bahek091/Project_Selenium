package tests;

import org.example.pageobject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckStatusOrderTest {
    private ChromeDriver driver;

    @Before
    public void startUp(){
        driver = new ChromeDriver();

    }

    @Test
    public void checkOrderStatusNotExistTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.statusOrderButtonClick();
        mainPage.setOrderNumber("NewValue");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
