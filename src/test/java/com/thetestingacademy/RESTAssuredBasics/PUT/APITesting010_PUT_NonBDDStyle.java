package com.thetestingacademy.RESTAssuredBasics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_PUT_NonBDDStyle {
//    BaseURI : https://restful-booker.herokuapp.com
//    Basepath : /booking/
//    "token": "6fdcc8088fb53b9"
//    bookingid": 4523
//    payload :
//{
//        "firstname" : "Jammy",
//        "lastname" : "Brown",
//        "totalprice" : 111,
//        "depositpaid" : true,
//        "bookingdates" : {
//        "checkin" : "2018-01-01",
//        "checkout" : "2019-01-01"
//        },
//        "additionalneeds" : "Breakfast"
//        }



    RequestSpecification rs;

    @Description("Verify the PUT Request for Restful Booker API")
    @Test
    public void test_put_non_bdd(){
        String token = "2cacf35e98a4b15";
        String bookingid = "1796";
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


        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload).log().all();

        Response res = rs.when().put();

        ValidatableResponse vr = res.then().log().all();
        vr.statusCode(200);
    }

}