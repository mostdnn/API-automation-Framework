package api.endpoints;

import api.payload.AuthPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthEndpoint {







    public static Response createtoken(AuthPojo payload){

        Response response= given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Roots.CreateToken);
        return response;

    }
}
