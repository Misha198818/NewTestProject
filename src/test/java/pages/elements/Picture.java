package pages.elements;

import java.io.File;
import java.io.FileNotFoundException;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class Picture {

    private SelenideElement selector;

    public Picture(SelenideElement selector){
        this.selector = selector;
    }

    @Step("Проверяем наличике кнопки Picture и загружаем файл")
    public void insertPicture(File file) throws FileNotFoundException{
        selector.shouldBe(Condition.visible).uploadFile(file);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                
    }

}
