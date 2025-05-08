package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class Hobbies {

    private SelenideElement selector;

    public Hobbies(SelenideElement selector){
        this.selector = selector;
    }

    @Step("Проверяем наличие элеметов и кликаем по ним")
    public Hobbies clickHobbies(){
        selector.shouldBe(Condition.visible).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    } 


}
