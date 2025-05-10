package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class Mobile {

    private SelenideElement selector;

    public Mobile(SelenideElement selector){
        this.selector = selector;
     }

    @Step("проверяем наличие поля Mobile")
    public Mobile visibleMobile() {
        selector.shouldBe(Condition.visible);
        return this;
    }

    @Step("Вводим значение в поле Mobile")
    public Mobile insertMobile(String name)  {
        selector.setValue(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;             
    }

    
    @Step("проверяем цвет контура поля Mobile")
    public Mobile colorMobile(String color)  {
        selector.shouldHave(Condition.cssValue("border-bottom-color", color));
        return this; 
    }

}
