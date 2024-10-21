package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private By statusOrderButton = By.xpath(".//button[contains(@class, 'Header_Link')]");
    private By orderNumberInput = By.xpath(".//div[starts-with(@class,'Input_InputContainer')]/input[@type='text']");
    private By goButton = By.xpath(".//div[starts-with(@class,'Header_SearchInput')]/button[text()='Go!']");
    private By cookieButton = By.xpath(".//button[contains(@class, 'App_CookieButton')]");
    private final String FAQ_QUESTION_PATTERN = ".//div[contains(@id, 'accordion__heading') and contains(text(), '%s')]";

    protected WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void openMainPage(){
        driver.get(MAIN_PAGE_URL);
    }

    public void statusOrderButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(statusOrderButton));
        driver.findElement(statusOrderButton).click();
    }

    public void setOrderNumber(String newValue){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderNumberInput));
        WebElement orderNumberWebElement = driver.findElement(orderNumberInput);
        orderNumberWebElement.clear();
        orderNumberWebElement.sendKeys(newValue);
    }

    public void goButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(goButton)).click();
       // driver.findElement(goButton).click();
    }

    private void scrollToElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void cookieButtonClick(){
        WebElement button = driver.findElement(cookieButton);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(button)).click();


    }


}
