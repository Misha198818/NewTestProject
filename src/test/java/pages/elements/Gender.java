package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class Gender {

    private SelenideElement selector;
    
    public Gender(SelenideElement selector){
        this.selector = selector;
     }

     @Step("проверяем наличие кнопок поля Gender")
     public Gender visibleGender(){
         selector.shouldBe(Condition.visible);
         return this;
     }

     @Step("Кликаем по лейблам поля Gender")
     public Gender clickGender(){
        selector.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
     }

     @Step("проверяем цвет лейблов Gender")
     public Gender colorGender(String color)  {
         selector.shouldHave(Condition.cssValue("color", color));
         return this; 
     }


}
