package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class Submit {

    private SelenideElement selector;

    public Submit(SelenideElement selector){
        this.selector = selector;
     }

    @Step("проверяем наличие кнопки Submit")
    public Submit visibleSubmit() {
        selector.shouldBe(Condition.visible);
        return this;
    }

    @Step("Кликаем по кнопке Submit")
    public Submit clickSubmit()  {
        selector.click();
        return this;             
    }

}
