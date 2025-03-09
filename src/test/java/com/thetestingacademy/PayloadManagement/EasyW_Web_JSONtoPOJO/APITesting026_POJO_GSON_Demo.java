package com.thetestingacademy.PayloadManagement.EasyW_Web_JSONtoPOJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting026_POJO_GSON_Demo {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    @Test
    public void test_Post_request() {
//        {
//            "firstname" :"Jim",
//                "lastname" :"Brown",
//                "totalprice" :111,
//                "depositpaid" :true,
//                "bookingdates" :{
//            "checkin" :"2018-01-01",
//                    "checkout" :"2019-01-01"
//        },
//            "additionalneeds" :"Breakfast"
//        }


        Booking booking = new Booking();
        booking.setFirstname("jim");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingDates);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType("application/json");
        requestSpecification.body(booking);

        response = requestSpecification.when().log().all().post();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
}