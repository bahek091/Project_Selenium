package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public static String MAIN_PAGE_URL = "";
    private By statusOrderButton = By.xpath("");
    private By orderNumberInput = By.xpath("");
    private By goButton = By.xpath("");

    private WebDriver driver;

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
                .until(ExpectedConditions.elementToBeClickable(goButton));
        driver.findElement(goButton).click();
    }


}
