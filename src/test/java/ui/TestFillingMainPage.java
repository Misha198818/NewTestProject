package ui;

import org.junit.jupiter.api.Test;

import pages.MainPage;

public class TestFillingMainPage extends BaseTest {
    
    MainPage mainPage = new MainPage();

    @Test
    public void Test(){
        mainPage.openSite();
        mainPage.fillFormMainPage();
        mainPage.chooseDateOfDateofBirth();    
        mainPage.chooseLaibleGender("Male");
           
    }

}
