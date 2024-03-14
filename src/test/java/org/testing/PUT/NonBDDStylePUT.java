package org.testing.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePUT {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "17fb759249a3b20";


    @Test
    public void testPutREQUEST() {


        // url
        // auth - token , da829f2541bfd38 , headers - json
        // id - 3548
        // payload
        String payload = "{\n" +
                "    \"firstname\" : \"Anju\",\n" +
                "    \"lastname\" : \"Sahuraj\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-03-24\",\n" +
                "        \"checkout\" : \"2024-03-31\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        String payloadPATCH = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/1969");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        //requestSpecification.body(payload).log().all();
        // Patch Request
        requestSpecification.body(payloadPATCH).log().all();


        // Calling PUT method on URI. After hitting we get Response
//        Response response = requestSpecification.when().put();

        Response response = requestSpecification.when().patch();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();


        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("James"));
        validatableResponse.body("lastname", Matchers.equalTo("Brown"));


    }

}
