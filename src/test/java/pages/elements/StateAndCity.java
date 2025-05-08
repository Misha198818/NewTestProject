package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class StateAndCity {

    private SelenideElement selectorState;
    private SelenideElement selectorCity;
 

    public StateAndCity(SelenideElement selectorState, SelenideElement selectorCity){
        this.selectorState = selectorState;
        this.selectorCity = selectorCity;

    }

    @Step("кликаем по списку state")
    public StateAndCity selectState(){
        selectorState.shouldBe(Condition.visible).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    
    @Step("кликаем по списку city")
    public StateAndCity selectCity(){
        selectorCity.shouldBe(Condition.visible).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    } 


}
