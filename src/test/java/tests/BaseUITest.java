package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseUITest {
    protected SafariDriver driver;

    @Before
    public void startUp(){
        initSafari();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

//    public void initChrome(){
//        driver = new ChromeDriver();
//    }

    public void initSafari(){
        driver = new SafariDriver();
    }

//    public void initFirefox(){
//        driver = new FirefoxDriver();
//    }
}
