package testReqRes;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestPut {
    @Test
    public void putMethod() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("Name", "Sheetal");
        requestParams.put("job", "teacher");

        baseURI = "https://reqres.in/api/users/52";


        String jobUpdated = given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .body(requestParams.toJSONString())
                .when()
                .put()
                .then()
                .statusCode(200)
                .log().all()
                .extract().jsonPath().getString("job");
        assertThat(jobUpdated, equalTo("teacher"));
    }
}
