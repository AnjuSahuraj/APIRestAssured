package org.testing.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStylePOST
{
    @Test
    public void testNonBDDpositive()
    {
        RequestSpecification r=RestAssured.given();
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        Response response=r.when().post();

        ValidatableResponse validatableResponse=response.then();
        String responsestring=response.asString();
        System.out.println(responsestring);
        validatableResponse.statusCode(200);


    }
}
