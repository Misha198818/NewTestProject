package pages;

import static com.codeborne.selenide.Selenide.$x;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import com.codeborne.selenide.Selenide;

import io.qameta.allure.Step;
import lombok.Getter;
import pages.elements.CurretAddress;
import pages.elements.DateofBirth;
import pages.elements.Email;
import pages.elements.FirstName;
import pages.elements.Gender;
import pages.elements.Hobbies;
import pages.elements.LastName;
import pages.elements.Mobile;
import pages.elements.Picture;
import pages.elements.StateAndCity;
import pages.elements.Submit;

@Getter

public class MainPage {

    private final static String BASE_URL = "https://demoqa.com/automation-practice-form";
    File file = new File("C:\\Users\\Михаил\\Desktop\\fileSelenide\\картинка.jpg");

    //для заполнения полей и проверок
    public String FirstName = "Василий";
    public String LastName = "Жданов";
    public String Email = "vasya@example.com";
    public String InvalidEmail = "vasyaexample.com";
    public String Gender = "Male";
    public String Mobile = "8920555232";
    public String InvalidMobile = "892055523";
    public String HobbieSports = "Sports";
    public String HobbieReading = "Reading";
    public String HobbieMusic= "Music";
    public String FileName= "картинка.jpg";
    public String FullDate = "15 March,1980";
    public String Address = "456 Elm St, Лондон Е1 6АН, Великобритания";
    public String StateAndCity = "NCR Delhi";

    public static String Year = "1980";
    public static String Month = "2";

    public static String BorderColor = "rgba(220, 53, 69, 1)";  
    

    protected final FirstName firstName = new FirstName($x("//input[@id='firstName']"));
    protected final LastName lastName = new LastName($x("//input[@id='lastName']"));
    protected final Email email = new Email($x("//input[@id='userEmail']"));
    protected final Mobile mobile = new Mobile($x("//input[@id='userNumber']"));

    protected final DateofBirth dateofBirth = new DateofBirth($x("//input[@id='dateOfBirthInput']"),
                                                             $x("//select[@class='react-datepicker__year-select']"),
                                                             $x("//select[@class='react-datepicker__month-select']"),
                                                             $x("//div[@class='react-datepicker__day react-datepicker__day--015 react-datepicker__day--weekend']")                                                                 
    );

    protected final Submit submit = new Submit($x("//button[@id='submit']"));


    protected final Gender maleGender = new Gender($x("//label[@for='gender-radio-1']"));
    protected final Gender femaleGender = new Gender($x("//label[@for='gender-radio-2']"));

    protected final Hobbies sports = new Hobbies($x("//label[@for='hobbies-checkbox-1']"));
    protected final Hobbies reading = new Hobbies($x("//label[@for='hobbies-checkbox-2']"));
    protected final Hobbies music = new Hobbies($x("//label[@for='hobbies-checkbox-3']"));

    protected final Picture picture = new Picture($x("//input[@id='uploadPicture']"));

    protected final CurretAddress curretAddress = new CurretAddress($x("//textarea[@id='currentAddress']"));

    protected final StateAndCity stateAndCity = new StateAndCity($x("//div[@id='state']"),
                                                                 $x("//div[@id='react-select-3-option-0']"),
                                                                 $x("//div[@id='city']"),
                                                                 $x("//div[@id='react-select-4-option-0']"));

    private Duration StandartDurationTime = Duration.ofSeconds(5);
    
    @Step("Открываем главную страницу")
    public void openSite(){
        Selenide.open(BASE_URL);
    }

    @Step("Заполняем текстовые поля формы")
    public void fillForm()  {
        firstName.visibleFirstName(StandartDurationTime)
                 .insertFirstName(FirstName);
        lastName.visibleLastName()
                .insertLastName(LastName);
        email.visibleEmail()
             .insertEmail(Email);
        mobile.visibleMobile()
              .insertMobile(Mobile);
        curretAddress.insertAddress(Address);      

    }

    @Step("заполняем поля невалидными значениями")
    public void fillFormInvalidValues()  {
        email.insertEmail(InvalidEmail);
        mobile.insertMobile(InvalidMobile);
              
    }

    @Step("Проверка цвета валидации полей")
    public void checkColor()  {
        email.colorEmail(BorderColor);
        firstName.colorFirstName(BorderColor);
        lastName.colorLastName(BorderColor);
        maleGender.colorGender(BorderColor);
        femaleGender.colorGender(BorderColor);
        mobile.colorMobile(BorderColor);
              
    }

    @Step("Кликаем лейблы gender и выбираем пол")
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

    @Step("Кликаем лейблы Hobbies и выбираем")
    public void chooseLaibleHobbies(String hobbie){                   
        sports.clickHobbies();
        reading.clickHobbies();
        music.clickHobbies();
        music.clickHobbies();
        reading.clickHobbies();
        sports.clickHobbies();

        switch(hobbie){
            case("Sports"):
                sports.clickHobbies();
                break;
            case("Reading"):
                reading.clickHobbies();
                break;
            case("Music"):
                music.clickHobbies();
                break;
            default:
                reading.clickHobbies();
                break;
        }
     
    }

    @Step("Загружаем файл")
    public void downloadPicture(){
        try {
            picture.insertPicture(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Step("кликаем выпадающие списки")
        public void chooseStateAndCity(){
            stateAndCity.clickState()
                        .selectState()
                        .clicktCity()
                        .selectCity();
    }
    
    

    @Step("Нажимаем кнопку submit")
    public void submitClick(){
        submit.clickSubmit();
    }  
}
