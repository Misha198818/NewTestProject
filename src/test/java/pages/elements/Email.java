package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class Email {

    private SelenideElement selector;

    public Email(SelenideElement selector){
        this.selector = selector;
     }

    @Step("проверяем наличие поля Email")
    public Email visibleEmail() {
        selector.shouldBe(Condition.visible);
        return this;
    }

    @Step("Вводим значение в поле Email")
    public Email insertEmail(String name)  {
        selector.setValue(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;             
    }
}
