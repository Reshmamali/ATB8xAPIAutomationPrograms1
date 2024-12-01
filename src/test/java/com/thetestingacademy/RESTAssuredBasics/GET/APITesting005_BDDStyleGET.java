package com.thetestingacademy.RESTAssuredBasics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting005_BDDStyleGET {

    @Description("TC1 BDDStyleGET - Positive Testcase ")
    @Test
    public void test_GET_Request_Possitive(){
        String pin_code = "413501";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+pin_code)
                .when().log().all()
                    .get()
                .then().log().all()
                    .statusCode(200);
    }

    @Description("TC1 BDDStyleGET - Negative Testcase ")
    @Test
    public void test_GET_Request_Negative(){
        String pin_code = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pin_code)
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(404);

    }


}
