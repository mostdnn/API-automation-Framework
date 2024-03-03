package api.test;

import api.endpoints.BookingEndpoint;
import api.endpoints.PingEndpoint;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PingTest {


    @Test
    public void Healthcheckgtest(){
        Response response = PingEndpoint.HealthCheckEndpoints();
        response.then().log().all().assertThat().statusCode(201);
    }

}
