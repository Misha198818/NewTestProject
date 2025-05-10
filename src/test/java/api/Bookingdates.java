package api;

import lombok.Getter;

@Getter

public class Bookingdates {

    public String checkin;
    public String checkout;

    public Bookingdates(String checkin,String checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    
    public Bookingdates(){}


}
