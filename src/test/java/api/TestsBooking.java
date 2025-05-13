package api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestsBooking {

    private static int bookingid;
    private final static String URL = "https://restful-booker.herokuapp.com";
    private static String tokenID;

    Bookingdates bookingDatesRequest = new Bookingdates("2018-01-01", "2022-01-01");
    BookingData bookingDataRequest = new BookingData("Rem",
                                                "Brown",
                                                2000,
                                                true,
                                                bookingDatesRequest,
                                                "Breakfast");

    AuthData authData = new AuthData("admin", "password123");

    Bookingdates bookingDatesUpdateRequest = new Bookingdates("2023-01-01", "2025-01-01");
    BookingData bookingDataUpdateRequest = new BookingData("Bred",
                                                            "Grey",
                                                            1980,
                                                            false,
                                                            bookingDatesUpdateRequest,
                                                            "Dinner");

    @DisplayName("проверка метода CreateBooking")
    @Step("создаем книгу, сверяем поля в запросе и в ответе")    
    @Test
    @Order(1)
    public void checkCreateBooking(){
     
        CreateBookingResponseData book = RestAssured.given()
                                            .filter(new AllureRestAssured())
                                            .baseUri(URL)
                                            .basePath("/booking")
                                            .body(bookingDataRequest)
                                            .contentType(ContentType.JSON)
                                            .when()
                                            .post()
                                            .then().log().all()
                                            .statusCode(200)
                                            .extract().as(CreateBookingResponseData.class);
        bookingid = book.getBookingid();

        assertEquals(bookingDataRequest.getFirstname(), book.getBooking().getFirstname());
        assertEquals(bookingDataRequest.getLastname(), book.getBooking().getLastname());
        assertEquals(bookingDataRequest.getTotalprice(), book.getBooking().getTotalprice());
        assertEquals(bookingDataRequest.getDepositpaid(), book.getBooking().getDepositpaid());
        assertEquals(bookingDataRequest.getAdditionalneeds(), book.getBooking().getAdditionalneeds());
        assertEquals(bookingDataRequest.getBookingdates().getCheckin(), book.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDataRequest.getBookingdates().getCheckout(), book.getBooking().getBookingdates().getCheckout());
    }

     @DisplayName("проверка метода UbdateBooking")
     @Step("получаем токен, обновляем и проверяем что все поля обновлены")
     @Test
     @Order(2)
     public void checkUpdateBooking(){

        TokenData token = RestAssured.given()
                           .filter(new AllureRestAssured())
                           .baseUri(URL)
                           .basePath("/auth")
                           .body(authData)
                           .contentType(ContentType.JSON)
                           .when().post()
                           .then().log().all()
                           .statusCode(200)
                           .extract().as(TokenData.class);
        
        tokenID = token.getToken();


        BookingData bookUpdate = RestAssured.given()
                                    .filter(new AllureRestAssured())
                                    .baseUri(URL)
                                    .basePath("/booking/" + bookingid)
                                    .body(bookingDataUpdateRequest)
                                    .contentType(ContentType.JSON) 
                                    .header("cookie", "token=" + token.getToken())                                   
                                    .when().put()
                                    .then().log().all()
                                    .statusCode(200)
                                    .extract().as(BookingData.class);

        assertEquals(bookingDataUpdateRequest.getFirstname(), bookUpdate.getFirstname());
        assertEquals(bookingDataUpdateRequest.getLastname(), bookUpdate.getLastname());
        assertEquals(bookingDataUpdateRequest.getTotalprice(), bookUpdate.getTotalprice());
        assertEquals(bookingDataUpdateRequest.getDepositpaid(), bookUpdate.getDepositpaid());
        assertEquals(bookingDataUpdateRequest.getAdditionalneeds(), bookUpdate.getAdditionalneeds());
        assertEquals(bookingDataUpdateRequest.getBookingdates().getCheckin(), bookUpdate.getBookingdates().getCheckin());
        assertEquals(bookingDataUpdateRequest.getBookingdates().getCheckout(), bookUpdate.getBookingdates().getCheckout());
        
       
     }

    @DisplayName("проверка метода GetBooking")
    @Step("Получаем книгу по id, проверяем пару полей что не пустые")
    @Test
    @Order(3)
    public void checkGetBooking(){

        BookingData getBook = RestAssured.given()
                                         .filter(new AllureRestAssured())
                                         .baseUri(URL)
                                         .basePath("/booking/" + bookingid)
                                         .contentType(ContentType.JSON)
                                         .when().get()
                                         .then().log().all()
                                         .statusCode(200)
                                         .extract().as(BookingData.class);

        Assertions.assertNotNull(getBook.getFirstname());
        Assertions.assertNotNull(getBook.getFirstname());                                 

    }


    @DisplayName("проверка метода Delete")
    @Step("Удаляем книгу по id, пробуем получить методом get, проверяем код ответа(404)")
    @Test
    @Order(4)
    public void checkDeleteBooking(){

            RestAssured.given()
                        .filter(new AllureRestAssured())
                        .baseUri(URL)
                        .basePath("/booking/" + bookingid)
                        .contentType(ContentType.JSON)
                        .header("cookie", "token=" + tokenID)                                   
                        .when().delete()
                        .then().log().all()
                        .statusCode(201);


            RestAssured.given()
                        .filter(new AllureRestAssured())
                        .baseUri(URL)
                        .basePath("/booking/" + bookingid)                                  
                        .when().get()
                        .then().log().all()
                        .statusCode(404);                                             
    }

}
