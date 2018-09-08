/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ce.apitesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @version 1.0, 08-Sep-2018
 * @author gourav
 */
public class GithubApiTest extends BaseClass {

    /**
     * Get list of all labels for a repository
     */
    @Test
    public void listAllLabelsOfRepo() {
        Response response = RestAssured
                                    .given()
                                        .header("Accept", "application/vnd.github.v3+json")
                                        .header("Authorization","token " + getAuthToken())
                                        //Normally this is how you would use your AUTH TOKEN
                                        //.header("Authorization","token " + getAuthToken())
                                    .when()
                                         .get("https://api.github.com/repos/gschambial/gschambial.github.io/labels")
                                         .andReturn();
        System.out.println("listAllLabelsOfRepo response: " + response.asString());
    }
    
    /**
     * list branches
     */
    @Test
    public void listBranches() {
        Response response = RestAssured
                                    .given()
                                        .header("Accept", "application/vnd.github.v3+json")
                                        .header("Authorization","token " + getAuthToken())
                                     .when()
                                         .get("https://api.github.com/repos/gschambial/git-tuts/branches")
                                         .andReturn();
        System.out.println("listBranches response: " + response.asString());
    }
    

}
