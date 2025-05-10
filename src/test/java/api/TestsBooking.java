package api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestsBooking {

    private static int bookingid;
    private final static String URL = "https://restful-booker.herokuapp.com/booking";
    Bookingdates bookingDatesRequest = new Bookingdates("2018-01-01", "2022-01-01");
    BookingData bookingDataRequest = new BookingData("Rem",
                                                "Brown",
                                                2000,
                                                true,
                                                bookingDatesRequest,
                                                "Breakfast");

    @DisplayName("проверка метода CreateBooking")
    @Test
    public void checkCreateBooking(){
     
        CreateBookingResponseData book = RestAssured.given()
                                            .filter(new AllureRestAssured())
                                            .body(bookingDataRequest)
                                            .contentType(ContentType.JSON)
                                            .when()
                                            .post(URL)
                                            .then().log().all()
                                            .statusCode(200)
                                            .extract().as(CreateBookingResponseData.class);
        bookingid = book.getBookingid();

        assertEquals(bookingDataRequest.getFirstname(), book.getBooking().getFirstname());
        assertEquals(bookingDataRequest.getLastname(), book.getBooking().getLastname());
    }

     @DisplayName("проверка метода UbdateBooking")
     @Test
     public void checkUpdateBooking(){
        System.out.println(bookingid);
     }


}
