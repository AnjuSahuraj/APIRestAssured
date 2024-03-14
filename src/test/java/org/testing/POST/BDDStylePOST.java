package org.testing.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.http.ContentType.JSON;

public class BDDStylePOST
{
    public static void main(String[] args)
    {
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com").basePath("/auth").contentType(ContentType.JSON).body(payload)
                .when().post()
                .then().log().all().statusCode(200);

    }


}
