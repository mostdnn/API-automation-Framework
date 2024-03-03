package api.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PingEndpoint {

    public static Response HealthCheckEndpoints(){
        Response response= given()
                .when()
                .get(Roots.Ping);
        return response;
    }







}
