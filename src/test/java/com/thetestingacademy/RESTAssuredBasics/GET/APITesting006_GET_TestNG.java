package com.thetestingacademy.RESTAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting006_GET_TestNG {
    @Test
    public void test_GET_Request(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .when()
                .get()
                .then().log().all()
                .statusCode(200);

    }
}
