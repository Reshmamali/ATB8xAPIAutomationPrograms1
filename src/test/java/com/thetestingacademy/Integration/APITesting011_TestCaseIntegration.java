package com.thetestingacademy.Integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting011_TestCaseIntegration {

    //  Create a Token
    // Create a Booking
    //  Perform  a PUT request
    //  Verify that PUT is success by GET Request
    // Delete the ID
    // Verify it doesn't exist GET Request


    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    String bookingId;

    public String getToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON).log().all();;
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);

        token = response.jsonPath().getString("token");
        System.out.println(token);
        return token;
    }

    public String getBookingid() {
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

        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);
        return bookingId;
    }

    @Test(priority = 1)
    public void test_update_request_put() {
         token = getToken();
        bookingId = getBookingid();
        System.out.println(token);
        System.out.println(bookingId);

        String payload = "{\n" +
                "    \"firstname\" : \"Reshma\",\n" +
                "    \"lastname\" : \"Mali\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/"+bookingId);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload).log().all();

        Response res = rs.when().put();

        ValidatableResponse vr = res.then().log().all();
        vr.statusCode(200);

    }
    @Test(priority = 2)
    public void test_update_request_get() {
        System.out.println(bookingId);

        requestSpecification.given().baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId);
        response = requestSpecification.when().log().all().get();
        requestSpecification.then().log().all().statusCode(200);

        String first_name = response.jsonPath().getString("firstname");
        Assert.assertEquals(first_name, "Reshma");
//        System.out.println(first_name);

    }
    @Test(priority = 3)
    public void test_delete_booking() {
        System.out.println(token);
        System.out.println(bookingId);

        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/"+bookingId);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);

        Response res = rs.when().put();

        ValidatableResponse vr = res.then().log().all();
        vr.statusCode(201);        // #TODO #1 -Delete Bug


    }
    @Test(priority = 4)
    public void test_after_delete_get() {
        System.out.println(bookingId);

        requestSpecification.given().baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId);
        response = requestSpecification.when().log().all().get();
        requestSpecification.then().log().all().statusCode(200);
    }
//#Todo #2 - We will add more assertions here in the future
}
