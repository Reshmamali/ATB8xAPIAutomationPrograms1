package com.thetestingacademy.PayloadManagement.DifficultWay;

public class BookingDatesD {
//    "bookingdates" : {
//           "checkin" : "2018-01-01",
//            "checkout" : "2019-01-01"
//       },

    private String checkin;
    private String checkout;

    public String getcheckin(String date){
        return checkin;
    }
    public void setCheckin(String checkin){
        this.checkin = checkin;
    }
    public String getcheckout(String date){
        return checkout;
    }
    public void setCheckout(String checkout){
        this.checkout = checkout;
    }
}
