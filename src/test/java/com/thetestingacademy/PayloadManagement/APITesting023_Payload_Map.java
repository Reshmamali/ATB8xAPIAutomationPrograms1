package com.thetestingacademy.PayloadManagement;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting023_Payload_Map {
    RequestSpecification requestSpecification ;
    ValidatableResponse validatableResponse ;
    Response response;

   @Test
    public void test_POST_Request(){
       //{
       //            "firstname" : "Jim",
       //                "lastname" : "Brown",
       //                "totalprice" : 111,
       //                "depositpaid" : true,
       //                "bookingdates" : {
       //                         "checkin" : "2018-01-01",
       //                         "checkout" : "2019-01-01"
       //                         },
       //            "additionalneeds" : "Breakfast"
       //        }

      // JSON to MAP
       Map<String, Object> jsonBodyUsingMap  = new LinkedHashMap();

       jsonBodyUsingMap.put("firstname", "Jim");
       jsonBodyUsingMap.put("lastname", "Brown");
       jsonBodyUsingMap.put("totalprice", 111);
       jsonBodyUsingMap.put("depositpaid", true);

       Map<String, Object> bookingDatesMap  = new LinkedHashMap();

       bookingDatesMap.put("checkin", "2018-01-01");
       bookingDatesMap.put("checkout", "2019-01-01");
       jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
       jsonBodyUsingMap.put("additionalneeds","Breakfast");

       // MAP to JSON >> by using GSON library

       requestSpecification = RestAssured.given();
       requestSpecification.baseUri("https://restful-booker.herokuapp.com");
       requestSpecification .basePath("/booking");
       requestSpecification .contentType("application/json");
       requestSpecification .body(jsonBodyUsingMap);

       response = requestSpecification.when().log().all().post();

       ValidatableResponse validatableResponse = response.then().log().all();
       validatableResponse.statusCode(200);

       String token = response.jsonPath().getString("token");
       System.out.println(token);


   }
}
