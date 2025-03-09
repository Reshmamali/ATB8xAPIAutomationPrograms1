package com.thetestingacademy.PayloadManagement.SerAndDeSerialization;

import com.google.gson.Gson;
import com.thetestingacademy.PayloadManagement.DifficultWay.BookingD;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class APITesting027_SerAndDeSer {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    @Test
    public void test_Post_Request_SerAndDeSer() {

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

        // Serialization
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(booking).log().all();

        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

//        De Serialization  >> Creating a object for pojo class  >> toConvert the JsonString to Object

        BookingResponse bookingResponse = gson.fromJson(jsonStringBooking, BookingResponse.class);
        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("jim").isNotNull().isNotEmpty();




    }
}
