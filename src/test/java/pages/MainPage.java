package pages;

import static com.codeborne.selenide.Selenide.$x;

import java.time.Duration;

import com.codeborne.selenide.Selenide;

import io.qameta.allure.Step;
import pages.elements.DateofBirth;
import pages.elements.Email;
import pages.elements.FirstName;
import pages.elements.Gender;
import pages.elements.LastName;
import pages.elements.Mobile;

public class MainPage {

    private final static String BASE_URL = "https://demoqa.com/automation-practice-form";

    public static String FirstName = "Василий";
    public static String LastName = "Жданов";
    public static String Email = "vasya@example.com";
    public static String Mobile = "8920555232";


    public static String Year = "1980";
    public static String Month = "2";

    protected final FirstName firstName = new FirstName($x("//input[@id='firstName']"));
    protected final LastName lastName = new LastName($x("//input[@id='lastName']"));
    protected final Email email = new Email($x("//input[@id='userEmail']"));
    protected final Mobile mobile = new Mobile($x("//input[@id='userNumber']"));

    protected final DateofBirth dateofBirth = new DateofBirth($x("//input[@id='dateOfBirthInput']"),
                                                             $x("//select[@class='react-datepicker__year-select']"),
                                                             $x("//select[@class='react-datepicker__month-select']"),
                                                             $x("//div[@class='react-datepicker__day react-datepicker__day--015 react-datepicker__day--weekend']")                                                                 
    );


    protected final Gender maleGender = new Gender($x("//label[@for='gender-radio-1']"));
    protected final Gender femaleGender = new Gender($x("//label[@for='gender-radio-2']"));

    private Duration StandartDurationTime = Duration.ofSeconds(5);
    
    @Step("Открываем главную страницу")
    public void openSite(){
        Selenide.open(BASE_URL);
    }

    @Step("Заполняем поля формы")
    public void fillFormMainPage()  {
        firstName.visibleFirstName(StandartDurationTime)
                 .insertFirstName(FirstName);

        lastName.visibleLastName()
                .insertLastName(LastName);

        email.visibleEmail()
             .insertEmail(Email);

        mobile.visibleMobile()
              .insertMobile(Mobile);     


    }

    @Step("Кликаем лейблы и выбираем пол")
    public void chooseLaibleGender(String gender){
        maleGender.visibleGender()
            .clickGender();

        femaleGender.visibleGender()
            .clickGender();
       
       if(gender.equals("Male")){
            maleGender.clickGender();   
       }                
    }

    @Step("Выбираем дату в календаре")
    public void chooseDateOfDateofBirth(){
        dateofBirth.clickDateofBirth()
                    .selectYear(Year)
                    .selectMonth(Month)
                    .selectDay();
    }

    
}
