package ui;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {

    public static void setBrouser(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 60000; //60 секунд
    }

    @BeforeAll
    public static void init(){
        setBrouser();
    }

    @AfterAll
    public static void close(){
        Selenide.closeWebDriver();
    }
}
