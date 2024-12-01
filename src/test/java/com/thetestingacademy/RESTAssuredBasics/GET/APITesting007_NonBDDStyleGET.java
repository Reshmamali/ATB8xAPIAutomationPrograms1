package com.thetestingacademy.RESTAssuredBasics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting007_NonBDDStyleGET {

    static RequestSpecification r = RestAssured.given();


    @Description("TC1 NonBDDStyleGET Get request Positive")
    @Test
    public void Test_GET_Request_Positive(){
        String pin_code = "413501";

        r.given().baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pin_code);
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

    @Description("TC1 NonBDDStyleGET Get request Negative")
    @Test
    public void Test_GET_Request_Negative(){
        String pin_code = "-1";

        r.given().baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pin_code);
        r.when().log().all().get();
        r.then().log().all().statusCode(404);
    }

}
