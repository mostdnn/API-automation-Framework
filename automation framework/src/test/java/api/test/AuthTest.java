package api.test;

import api.endpoints.AuthEndpoint;
import api.payload.AuthPojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthTest {

    Faker faker;
    AuthPojo paylod;
    public static String token;


    @BeforeTest
    public void setupdata(){
        faker=new Faker();
        paylod=new AuthPojo();
        paylod.setUsername("admin");
        paylod.setPassword("password123");




    }




    @Test
    public  void testAuth(){
        Response response= AuthEndpoint.createtoken(paylod);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        response.then().extract().response();
        token = response.path("token");
        System.out.println(token);

    }

}
