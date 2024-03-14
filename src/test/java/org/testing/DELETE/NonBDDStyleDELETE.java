package org.testing.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyleDELETE
{
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "4ab5f15e68cd0ad";
    @Test
    public void testNonBDDDELETE()
    {
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/2324");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        Response response=requestSpecification.when().delete();

        String responsestring=response.asString();
        validatableResponse=response.then().log().all().statusCode(201);
    }
}
