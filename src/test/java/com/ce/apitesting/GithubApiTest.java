/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ce.apitesting;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ce.apitesting.response.LabelResponse;

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
        //First Assertion
        assertNotNull(response);
        
        LabelResponse[] labelResponse = response.as(LabelResponse[].class);
        System.out.println("listAllLabelsOfRepo response: " + response.asString());
        
        //Second Assertion
        assertNotEquals(labelResponse.length, 0);
        
        System.out.println("listAllLabelsOfRepo response size: " + labelResponse.length);
        
        for (LabelResponse label : labelResponse) {
            System.out.println("id: " + label.getId());
            System.out.println("default: " + label.isDefaultValue());
            
            //Third Assertion
            assertTrue(labelResponse[0].isDefaultValue());
        }
        
        
        
    }
    
    /**
     * Get list of all labels for a repository
     */
    @Test
    public void listAllLabelsOfRepoAssertions() {
        RestAssured
            .given()
                .header("Accept", "application/vnd.github.v3+json")
                .header("Authorization","token " + getAuthToken())
            .when()
                .get("https://api.github.com/repos/gschambial/gschambial.github.io/labels")
            .then()
                .assertThat()
                    .statusCode(200);
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
