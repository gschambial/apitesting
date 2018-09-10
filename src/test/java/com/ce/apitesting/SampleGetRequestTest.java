/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */  
package com.ce.apitesting;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.ce.apitesting.request.User;
import com.ce.apitesting.response.UserResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 *  
 *  @version     1.0, 10-Sep-2018
 *  @author gourav
 */
public class SampleGetRequestTest extends BaseClass{
    
    @Test
    public void samplePostRequestWithObjectBody() {
        
        //Create User object
        User user = new User();
        user.setName("John");
        user.setJob("leader");
        
        Response response = RestAssured
                                .given()
                                    .body(user)
                                    .header("Content-Type", "application/json")
                                .when()
                                    .post("https://reqres.in/api/users")
                                    .andReturn();
         System.out.println("sampleGetRequestWithObjectBody Response: " + response.asString());                           
    }
    
    @Test
    public void samplePostRequestWithJsonBody() {
        
        //Create User object
        User user = new User();
        user.setName("John");
        user.setJob("leader");
        
        Response response = RestAssured
                                .given()
                                    .body(user)
                                    .header("Content-Type", "application/json")
                                .when()
                                    .post("https://reqres.in/api/users")
                                    .andReturn();
         System.out.println("samplePostRequestWithJsonBody Response: " + response.asString());     
         
         
         //parse JSON response to class
         UserResponse userResponse = response.as(UserResponse.class);
         System.out.println("name : " + userResponse.getName());
         System.out.println("job : " + userResponse.getId());
         System.out.println("id : " + userResponse.getId());
         System.out.println("createdAt : " + userResponse.getCreatedAt());
    }
    
    @Test
    public void sampleGetRequestWithQueryParam() {
        
        Response response = RestAssured
                                .given()
                                    .param("page", 2)
                                .when()
                                    .get("https://reqres.in/api/users")
                                    .andReturn();
         System.out.println("sampleGetRequestWithQueryParam Response: " + response.asString());                           
    }
    
    @Test
    public void sampleGetRequestWithPathParam() {
        
        Response response = RestAssured
                                .given()
                                    .pathParam("userId", 2)
                                .when()
                                    .get("https://reqres.in/api/users/{userId}")
                                    .andReturn();
         System.out.println("sampleGetRequestWithPathParam Response: " + response.asString());  
         assertEquals(response.getStatusCode(), 200);
    }
    
    @Test
    public void sampleGetRequestWithPathParam404() {
        
        Response response = RestAssured
                                .given()
                                    .pathParam("userId", 23)
                                .when()
                                    .get("https://reqres.in/api/users/{userId}")
                                    .andReturn();
         System.out.println("sampleGetRequestWithPathParam404 Response: " + response.asString());
         assertEquals(response.getStatusCode(), 404);
    }

}
