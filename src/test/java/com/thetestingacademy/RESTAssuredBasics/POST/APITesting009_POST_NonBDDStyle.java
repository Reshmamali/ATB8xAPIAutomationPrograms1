package com.thetestingacademy.RESTAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_POST_NonBDDStyle {
//    Post request
//    URL : https://restful-booker.herokuapp.com/auth
//    Content type : 'Content-Type: application/json'
//    body : {
//    "username" : "admin",
//    "password" : "password123"

    RequestSpecification requestSpecification = RestAssured.given();

    @Description("TC1 Post-Request CreateToken - positive")
    @Test
    public void test_POST_NonBDDStyle() {
        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
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
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification .basePath("/booking");
        requestSpecification .contentType("application/json");
        requestSpecification .body(payload);

        Response response = requestSpecification.when().log().all().post();

        ValidatableResponse validatableResponse = response.then().log().all()
                .statusCode(200);

        String token = response.jsonPath().getString("token");
        System.out.println(token);


    }
}
