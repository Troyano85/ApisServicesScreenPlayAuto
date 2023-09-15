package testReqRes;


import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestDelete {
    @Test
    public void deleteMethod() {

        baseURI = "https://reqres.in/api/users/52";

        given()
                .when()
                .delete().
                then()
                .statusCode(204)
                .log().all();
    }
}
