package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class DateofBirth {

    private SelenideElement selector;
    private SelenideElement selectorYear;
    private SelenideElement selectorMonth;
    private SelenideElement selectorDay;

    public DateofBirth(SelenideElement selector, 
                       SelenideElement selectorYear,
                       SelenideElement selectorMonth,
                       SelenideElement selectorDay){
        this.selector = selector;
        this.selectorYear = selectorYear;
        this.selectorMonth = selectorMonth;
        this.selectorDay = selectorDay;
     }

    @Step("проверяем наличие поля DateofBirth")
    public DateofBirth visibleMobile() {
        selector.shouldBe(Condition.visible);
        return this;
    }

    @Step("Кликаем по полю DateofBirth")
    public DateofBirth clickDateofBirth()  {
        selector.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;             
    }

    @Step("Выбираем год")
    public DateofBirth selectYear(String year){
        selectorYear.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectorYear.selectOptionByValue(year);
        return this;
    }

    @Step("Выбираем месяц")
    public DateofBirth selectMonth(String month){
        selectorMonth.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectorMonth.selectOptionByValue(month);
        return this;
    }

    @Step("Выбираем день")
    public DateofBirth selectDay(){
        selectorDay.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

}
