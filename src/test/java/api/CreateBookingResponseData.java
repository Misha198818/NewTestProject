package api;

import lombok.Getter;

@Getter

public class CreateBookingResponseData {

    public Integer bookingid;
    public BookingData booking;


    public CreateBookingResponseData(Integer bookingid, BookingData booking){
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public CreateBookingResponseData(){
    }


}
