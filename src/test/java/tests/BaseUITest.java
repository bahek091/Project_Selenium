package tests;

import org.example.pageobject.MainPage;
import org.example.pageobject.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseUITest {
    protected ChromeDriver driver;

    @Before
    public void startUp(){
        initChrome();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public void initChrome(){
        driver = new ChromeDriver();
    }

    protected MainPage openMainPage(WebDriver driver){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.cookieButtonClick();
        return mainPage;
    }


    //public void initSafari(){
//        driver = new SafariDriver();
//    }

//    public void initFirefox(){
//        driver = new FirefoxDriver();
//    }
}
