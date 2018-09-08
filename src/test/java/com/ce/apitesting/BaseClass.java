/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ce.apitesting;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @version 1.0, 08-Sep-2018
 * @author gourav
 */
public class BaseClass {

    private String authToken;

    @BeforeSuite
    public void login() {
        Response response = RestAssured
                                .given()
                                    .header("Accept", "application/vnd.github.v3+json")
                                    .auth()
                                        .basic("gschambial", "13Torrishn@do93")
                                 .when()
                                     .get("https://api.github.com")
                                  .andReturn();
        System.out.println("login response: " + response.asString());
        //This x-auth-token is used by all subsequent requests
        authToken = response.cookie("x-auth-token");
        //But we are Hard Coding the token here
        authToken = "YOUR-PERSONAL-ACCESS-TOKEN-GOES-HERE";
        
    }

    public String getAuthToken() {
        return authToken;
    }

}
