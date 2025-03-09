package com.thetestingacademy.ExtractDataWays;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting022_twoWaysToExtractTheData {
    RequestSpecification requestSpecification = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void test_POST_Create_Booking_NonBDDStyle() {

            String payload = "{\n" +
                    "    \"firstname\" : \"jammy\",\n" +
                    "    \"lastname\" : \"Brown\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : true,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2018-01-01\",\n" +
                    "        \"checkout\" : \"2019-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Breakfast\"\n" +
                    "}";

            requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
            requestSpecification.basePath("/booking");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(payload).log().all();

            response = requestSpecification.when().post();

            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);


//            Validatable Response Assertions
        // - I - Hamcrest - Rest Assured >> by default available
        // import org.hamcrest.Matchers;



        String firstName = response.then().extract().path("booking.firstname");
        String lastName = response.then().extract().path("booking.lastname");
        System.out.println("Customer name is " + firstName +" "+ lastName);

        Integer bookingId = response.then().extract().path("bookingid");
        System.out.println("Booking id is " + bookingId);

        String bookingdates = response.jsonPath().getString("booking.bookingdates");
        System.out.println("Booking dates are " + bookingdates);

        Integer totalprice = response.then().extract().path("booking.totalprice");
        System.out.println("Total Price is " + totalprice);

        Boolean depositpaid = response.then().extract().path("booking.depositpaid");
        System.out.println("deposit paid is" + " " + depositpaid);

        String additionalneeds = response.jsonPath().getString("booking.additionalneeds");
        System.out.println("Additional need is "+ " " + additionalneeds);

        String checkout = response.then().extract().path("booking.bookingdates.checkout");
        System.out.println("Checkout date is " + checkout );









        // TestNG Assertions  -

        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.


        // AssertJ( 3rd- Lib to Assertions)




    }
}
