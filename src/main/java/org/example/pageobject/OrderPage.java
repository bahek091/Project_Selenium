package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage extends MainPage{

    public static String ORDER_PAGE_URL = MAIN_PAGE_URL + "order";
    public static final String YANDEX_URL = "https://dzen.ru/?yredirect=true";


    private By headerYandexLogoLink = By.xpath(".//a[contains(@class, 'Header_LogoYandex')]");
    private By headersamokatLogoLink = By.xpath(".//a[contains(@class, 'Header_LogoScooter')]");
    private By deliveryDateInput = By.xpath(".//div[@class='react-datepicker__input-container']/input[@type='text']");
    private By deliveryDatePicker = By.xpath(".//div[contains(@class,'react-datepicker__day--selected')]");
    private By formFirstNameInput = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    private By formLastNameInput = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    private By formAdressInput = By.xpath(".//input[contains(@placeholder,'Адрес')]");
    private By formMetroStationInput = By.xpath(".//input[contains(@placeholder,'Станция метро')]");
    private By formPhoneInput = By.xpath(".//input[contains(@placeholder,'Телефон')]");
    private By formDateInput = By.xpath(".//input[contains(@placeholder,'Когда привезти')]");
    private By formDurationDiv = By.xpath(".//div[@class = 'Dropdown-placeholder']");
    private By formCommentInput = By.xpath(".//input[contains(@placeholder,'Комментарий')]");
    private By formNextButton = By.xpath(".//button[text()='Далее']");
    private By formOrderButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]//button[text()='Заказать']");
    private By formModalYesButton = By.xpath(".//div[contains(@class,'Order_Modal')]//button[text()='Да']");
    private final String METRO_PATTERN = ".//*[contains(text(), '%s')]";
    private final String DURATION_PATTERN = ".//div[contains(@class, 'Dropdown-option') and text()='%s']";
    private final String COLOR_PATTERN = ".//input[@type = 'checkbox' and @id='%s']";



    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void openOrderPage(){
        driver.get(ORDER_PAGE_URL);
    }

    public void clickYandexLogo(){
        driver.findElement(headerYandexLogoLink).click();
    }

    public void clickSamokatLogo(){
        driver.findElement(headersamokatLogoLink).click();
    }

    public void fillOrderForm(String firstName, String LastName, String adress, String metroStation,
                              String phone, String deliveryDate, String duration, String color, String comment){
        fillInputText(formFirstNameInput, firstName);
        fillInputText(formLastNameInput, LastName);
        fillInputText(formAdressInput, adress);
        selectMetroStation(metroStation, formMetroStationInput);
        fillInputText(formMetroStationInput, metroStation);
        fillInputText(formPhoneInput, phone);
        orderFormNextButtonClick();
        selectDeliveryDate(deliveryDate);
        driver.findElement(formDurationDiv).click();
        driver.findElement(By.xpath(String.format(DURATION_PATTERN,duration))).click();
        driver.findElement(By.xpath(String.format(COLOR_PATTERN,color))).click();
        driver.findElement(formCommentInput).sendKeys(comment);
        driver.findElement(formOrderButton).click();

    }

    public void selectDeliveryDate(String date){
        driver.findElement(formDateInput).sendKeys(date);
        new WebDriverWait(driver, Duration.ofSeconds(MainPage.WAIT_TIMEOUT_2_SEC))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDatePicker)).click();
    }

    public void modalYesButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(MainPage.WAIT_TIMEOUT_2_SEC))
                .until(ExpectedConditions.elementToBeClickable(formModalYesButton)).click();
    }

    private void fillInputText(By element, String text){
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    private void selectMetroStation(String station, By locator){
        WebElement input = driver.findElement(locator);
        input.sendKeys(station);
        driver.findElement(By.xpath(String.format(METRO_PATTERN, station))).click();
        //((JavascriptExecutor)driver).executeScript("arguments[0].value=arguments[1];",input,text);
    }

    public boolean isOrderConfirmationWindowShown(){
        new WebDriverWait(driver, Duration.ofSeconds(MainPage.WAIT_TIMEOUT_2_SEC))
                .until(ExpectedConditions.elementToBeClickable(formModalYesButton)).click();
        return driver.findElement(formModalYesButton).isDisplayed();
    }

    public void orderFormNextButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(MainPage.WAIT_TIMEOUT_2_SEC))
                .until(ExpectedConditions.elementToBeClickable(formNextButton)).click();
    }



}
