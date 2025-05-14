package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class StateAndCity {

    private SelenideElement selectorState;
    private SelenideElement selectorCity;
    private SelenideElement selectFromListState;
    private SelenideElement selectFromListCity;

 

    public StateAndCity(SelenideElement selectorState,
                        SelenideElement selectFromListState,
                        SelenideElement selectorCity,
                        SelenideElement selectFromListCity){
        this.selectorState = selectorState;
        this.selectFromListState = selectFromListState;
        this.selectorCity = selectorCity;
        this.selectFromListCity = selectFromListCity;

    }

    @Step("кликаем по списку state")
    public StateAndCity clickState(){
        selectorState.shouldBe(Condition.visible).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Выбираем из списка state")
    public StateAndCity selectState(){
            selectFromListState.click();
            return this;
    }
    
    @Step("кликаем по списку city")
    public StateAndCity clicktCity(){
        selectorCity.shouldBe(Condition.visible).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Выбираем из списка city")
    public StateAndCity selectCity(){
            selectFromListCity.click();
            return this;
    }

}
