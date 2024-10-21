package org.example.pageobject;

import com.google.common.eventbus.SubscriberExceptionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage extends MainPage{

    private By deliveryDateInput = By.xpath(".//div[@class='react-datepicker__input-container']/input[@type='text']");
    private By deliveryDatePicker = By.xpath(".//div[contains(@class,'react-datepicker__day--selected')]");


    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void selectDeliveryDate(String date){
        WebElement deliveryDateInputElement = driver.findElement(deliveryDateInput);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(deliveryDateInputElement));
        deliveryDateInputElement.clear();
        deliveryDateInputElement.sendKeys(date);
        driver.findElement(deliveryDatePicker).click();

    }

    public void selectDeliveryDateJS(String date){
        WebElement deliveryDateInputElement = driver.findElement(deliveryDateInput);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(deliveryDateInputElement));
        ((JavascriptExecutor)driver).executeScript("arguments[0].value = arguments[1]", deliveryDateInputElement, date);
    }


}
