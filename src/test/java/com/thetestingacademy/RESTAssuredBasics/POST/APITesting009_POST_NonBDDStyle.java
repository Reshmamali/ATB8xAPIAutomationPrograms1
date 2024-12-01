package com.thetestingacademy.RESTAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_POST_NonBDDStyle {
//    Post request
//    URL : https://restful-booker.herokuapp.com/auth
//    Content type : 'Content-Type: application/json'
//    body : {
//    "username" : "admin",
//    "password" : "password123"

    RequestSpecification r = RestAssured.given();

    @Description("TC1 Post-Request CreateToken - positive")
    @Test
    public void test_POST_NonBDDStyle(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

                r.given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/auth")
                        .contentType("application/json")
                        .body(payload);
                r.when().log().all()
                        .post();
                r.then().log().all()
                        .statusCode(200);


    }
}
