package ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ModalPage;

public class TestFillingMainPage extends BaseTest {
    
    MainPage mainPage = new MainPage();
    ModalPage modalPage = new ModalPage();


    //проверка заполнения формы
    //заполняем форму валидными значениями
    //нажимаем submit
    @DisplayName("Заполняем форму")
    @Test
    public void TestFillingForm(){
        mainPage.openSite();
        mainPage.fillForm();   
        mainPage.chooseLaibleGender(mainPage.getGender());
        mainPage.chooseDateOfDateofBirth();
        mainPage.chooseLaibleHobbies(mainPage.getHobbieSports());
        mainPage.downloadPicture();
        mainPage.chooseStateAndCity();
        mainPage.submitClick();           
    }

    @DisplayName("проверка результатов заполнения в модальном окне")
    @Test
    public void TestModal(){
       modalPage.fillMapTable();

       assertEquals(modalPage.getMapTable("Student Name"), mainPage.getFirstName() + " " + mainPage.getLastName());
       assertEquals(modalPage.getMapTable("Student Email"), mainPage.getEmail());
       assertEquals(modalPage.getMapTable("Gender"), mainPage.getGender());
       assertEquals(modalPage.getMapTable("Mobile"), mainPage.getMobile());
       assertEquals(modalPage.getMapTable("Hobbies"), mainPage.getHobbieSports());
       assertEquals(modalPage.getMapTable("Picture"), mainPage.getFileName());
       assertEquals(modalPage.getMapTable("Address"), mainPage.getAddress());
       assertEquals(modalPage.getMapTable("State and City"), mainPage.getStateAndCity());


  }   
}

