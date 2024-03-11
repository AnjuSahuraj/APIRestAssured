package org.testing.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETReqNonBDDTestNG
{

        @Test
        public void testGetAllBookingsPositive()
        {
            // https://restful-booker.herokuapp.com/booking/1
            RequestSpecification r = RestAssured.given();

            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/2428").log().all();
            r.when().get();
            r.then().log().all().statusCode(200);
        }

        @Test
        public void testGetAllBookingsNegative1()
        {

            // https://restful-booker.herokuapp.com/booking/1
            RequestSpecification r = RestAssured.given();

            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/2002").log().all();
            r.when().get();
            r.then().log().all().statusCode(404);

        }

        @Test
        public void testGetAllBookingsNegative2()
        {

            // https://restful-booker.herokuapp.com/booking/1
            RequestSpecification r = RestAssured.given();

            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/-1").log().all();
            r.when().get();
            r.then().log().all().statusCode(404);

        }

}


