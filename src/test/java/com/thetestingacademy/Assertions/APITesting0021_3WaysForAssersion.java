package com.thetestingacademy.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.*;


public class APITesting0021_3WaysForAssersion {
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


//      Validatable Response Assertions           ||     import org.hamcrest.Matchers;
        validatableResponse.body("booking.firstname", Matchers.equalTo("jammy"));   // - I - Hamcrest - Rest Assured >> by default available

//      TestNG Assertions

        // Extract data
        String firstName = response.then().extract().path("booking.firstname");
        String lastName = response.then().extract().path("booking.lastname");
        Integer BookingId = response.then().extract().path("bookingid");
        Boolean depositpaid = response.then().extract().path("booking.depositpaid");

        // Hard Assersion
        Assert.assertEquals(firstName,"jammy");
        Assert.assertTrue(depositpaid);

        // SoftAssersion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();

//        AsserJ Core Assertion       (it's a library)
        // Add dependencies in pom.xml file
        // import ( import static org.assertj.core.api.Assertions.*; )

        assertThat(firstName).isEqualTo("jammy").isNotBlank().isNotNull().isNotEmpty();
        assertThat(lastName).isEqualTo("Brown").isNotBlank().isNotNull().isNotEmpty();

    }
}
