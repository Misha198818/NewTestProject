package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class LastName {

    private SelenideElement selector;

    public LastName(SelenideElement selector){
        this.selector = selector;
     }

    @Step("проверяем наличие поля LastName")
    public LastName visibleLastName() {
        selector.shouldBe(Condition.visible);
        return this;
    }

    @Step("Вводим значение в поле LastName")
    public LastName insertLastName(String name)  {
        selector.setValue(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;             
    }

    @Step("проверяем цвет контура поля LastName")
    public LastName colorLastName(String color)  {
        selector.shouldHave(Condition.cssValue("border-bottom-color", color));
        return this; 
    }


}
