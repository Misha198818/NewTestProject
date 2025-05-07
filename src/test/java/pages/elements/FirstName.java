package pages.elements;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class FirstName {

    private SelenideElement selector;

    public FirstName(SelenideElement selector){
        this.selector = selector;
     }


    @Step("проверяем наличие поля FirstName")
    public FirstName visibleFirstName(Duration time){
        selector.shouldBe(Condition.visible, time);
        return this;
    }

    @Step("Вводим значение в поле FirstName")
    public FirstName insertFirstName(String name) {
        selector.setValue(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;             
    }



}
