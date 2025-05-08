package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class CurretAddress {

   private SelenideElement selector;

    public CurretAddress(SelenideElement selector){
        this.selector = selector;
    }
    
    @Step("Проверяем наличие поля и заполняем")
    public CurretAddress insertAddress(String address){
        selector.shouldBe(Condition.visible).setValue(address);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    } 

}
