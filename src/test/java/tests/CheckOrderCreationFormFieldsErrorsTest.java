package tests;

import org.example.pageobject.MainPage;
import org.example.pageobject.OrderPage;
import org.junit.Assert;
import org.junit.Test;

public class CheckOrderCreationFormFieldsErrorsTest extends BaseUITest{

    @Test
    public void shouldShowErrorTipsTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.headerOrderButtonClick();
        OrderPage orderPage = new OrderPage(driver);
      //  orderPage.orderForm

    }

}
