package ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ModalPage;

public class TestFillingMainPage extends BaseTest {
    
    MainPage mainPage = new MainPage();
    ModalPage modalPage = new ModalPage();


    //проверка заполнения формы
    @Test
    public void TestFillingForm(){
        mainPage.openSite();
        mainPage.fillFormMainPage();   
        mainPage.chooseLaibleGender(mainPage.getGender());
        mainPage.chooseDateOfDateofBirth();
        mainPage.chooseLaibleHobbies(mainPage.getHobbieSports());
        mainPage.downloadPicture();
        mainPage.chooseStateAndCity();
        mainPage.submitClick();           
    }

    //проверка результатов заполнения в модальном окне
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
                
  }   
}

