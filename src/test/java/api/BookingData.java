package api;

import lombok.Getter;

@Getter


public class BookingData{

    public String firstname;
    public String lastname;
    public Integer totalprice;
    public Boolean depositpaid;
    public Bookingdates bookingdates;
    public String additionalneeds;

    public BookingData (String firstname,
                         String lastname,
                         Integer totalprice,
                         Boolean depositpaid,
                         Bookingdates bookingdates,
                         String additionalneeds){
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }


        public BookingData (){}
}
