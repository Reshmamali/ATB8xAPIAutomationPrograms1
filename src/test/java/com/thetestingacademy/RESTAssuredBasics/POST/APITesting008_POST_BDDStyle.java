package com.thetestingacademy.RESTAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting008_POST_BDDStyle {

//    Post request
//    URL : https://restful-booker.herokuapp.com/auth
//    Content type : 'Content-Type: application/json'
//    body : {
//    "username" : "admin",
//    "password" : "password123"
//}

    @Description("TC1 BDDStyle Post request - Positive")
    @Test
    public void test_POST_Positive(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType("application/json")
                    .body(payload)
                .when().log().all()
                    .post()
                .then().log().all()
                    .statusCode(200);

    }
}


