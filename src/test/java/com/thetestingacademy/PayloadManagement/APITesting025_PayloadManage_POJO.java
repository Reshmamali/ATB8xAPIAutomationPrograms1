package com.thetestingacademy.PayloadManagement;

import com.thetestingacademy.PayloadManagement.DifficultWay.BookingD;
import com.thetestingacademy.PayloadManagement.DifficultWay.BookingDatesD;
import com.thetestingacademy.PayloadManagement.EasyW_Web_JSONtoPOJO.Booking;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting025_PayloadManage_POJO {
    RequestSpecification requestSpecification ;
    ValidatableResponse validatableResponse ;
    Response response;

    @Test
    public void test_POST_Request(){
//        {
//                    "firstname" : "Jim",
//                        "lastname" : "Brown",
//                        "totalprice" : 111,
//                        "depositpaid" : true,
//                        "bookingdates" : {
//                                 "checkin" : "2018-01-01",
//                                 "checkout" : "2019-01-01"
//                                 },
//                    "additionalneeds" : "Breakfast"
//                }

        BookingD booking = new BookingD();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDatesD bookingDatesD = new BookingDatesD();
        bookingDatesD.getcheckin("2018-01-01");
        bookingDatesD.getcheckout("2019-01-01");
        booking.setBookingdates(bookingDatesD);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(booking).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your Booking Id is -> " +  bookingId);


    }

}
