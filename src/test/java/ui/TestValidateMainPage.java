package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.MainPage;

public class TestValidateMainPage extends BaseTest{

     MainPage mainPage = new MainPage();

     //где есть валидация значений заполняем невалидными
     //где обязательные поля не заполняем
     //проверяем что цвет изменился после нажатия на submit
     @DisplayName("Проверка валидации полей")
     @Test
     public void TestValidateFields(){
        mainPage.openSite();
        mainPage.fillFormInvalidValues();
        mainPage.submitClick();
        mainPage.checkColor();
        
     }

}
