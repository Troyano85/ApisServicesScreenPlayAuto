package testReqRes;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestPatch {
    @Test
    public void patchMethod() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "David");
        requestParams.put("job", "tester ");

        baseURI = "https://reqres.in/api/users/52";


        String nameUpdated = given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .body(requestParams.toJSONString())
                .when()
                .patch()
                .then()
                .statusCode(200)
                .log().all()
                .extract().jsonPath().getString("name");
        assertThat(nameUpdated, equalTo("David"));

    }
}
