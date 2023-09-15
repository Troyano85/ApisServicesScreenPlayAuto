package testReqRes;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;

public class TestGetUser {
    @Test
    public void getMethod() {

        baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/users/2");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);


    }
}
