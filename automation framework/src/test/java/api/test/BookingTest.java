package api.test;


import api.endpoints.BookingEndpoint;
import api.payload.BookingPojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingTest {


    Faker faker;
    BookingPojo paylod;
    public static int Booking_id;

    @BeforeTest
    public void setupdata(){
        faker=new Faker();
        paylod=new BookingPojo();
        paylod.setFirstname(faker.name().firstName());
        paylod.setLastname(faker.name().lastName());
        paylod.setTotalprice(faker.number().numberBetween(100, 1000));
        paylod.setDepositpaid(faker.random().nextBoolean());
        HashMap<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2013-01-01");
        bookingDates.put("checkout","2011-01-01");
        paylod.setBookingdates(bookingDates);
        paylod.setAdditionalneeds(faker.lorem().word());

    }
    @Test(priority = 1)
    public void createbookingtest(){
        Response response = BookingEndpoint.createBooking(paylod);

        response.then().log().all().assertThat().statusCode(200);
        response.then().extract().response();
        Booking_id = response.path("bookingid");
        System.out.println(Booking_id);

    }
    @Test(priority = 2)
    public void getbookingtest(){
        Response response = BookingEndpoint.GetBookingIds();
        response.then().log().all().assertThat().statusCode(200);
    }

    @Test(priority = 3)
    public void getbookingbyidtest(){
        Response response = BookingEndpoint.GetBookingByIds(1);
        response.then().log().all().assertThat().statusCode(200);
    }
    @Test(priority = 4)
    public void updatetbookingtest(){
        Response response = BookingEndpoint.updateBooking(paylod,1);
        response.then().log().all().assertThat().statusCode(200);
    }
    @Test(priority = 5)
    public void partialupdatetbookingtest(){
        Response response = BookingEndpoint.partialupdateBooking(paylod,1);
        response.then().log().all().assertThat().statusCode(200);
    }
    @Test(priority = 6)
    public void deletebookingtest(){
        Response response = BookingEndpoint.deleteBooking(Booking_id);
        response.then().log().all().assertThat().statusCode(201);
    }

    @Test(priority = 7)
    public void getbookingafterdeletetest(){
        Response response = BookingEndpoint.GetBookingByIds(Booking_id);
        response.then().log().all().assertThat().statusCode(404);
    }





}
