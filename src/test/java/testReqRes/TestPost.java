package testReqRes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;


public class TestPost {
    @Test
    public void postMethod() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("Name", "Prachi");
        requestParams.put("job", "QA ");

        baseURI = "https://reqres.in/api/users";


        RestAssured
                .given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .body(requestParams.toJSONString())
                .when()
                .post()
                .then()
                .statusCode(201)
                .log().all();


    }
}
