package api.endpoints;

import api.payload.BookingPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.test.AuthTest.token;
import static io.restassured.RestAssured.given;

public class BookingEndpoint {


    public static Response createBooking(BookingPojo payload){
       Response response= given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Roots.CreateBooking);
       return response;
    }

    public static Response GetBookingIds(){
        Response response= given()
                .when()
                .get(Roots.GetBookingIds);
        return response;
    }

    public static Response GetBookingByIds(int id){
        Response response= given()
                .pathParam("id", id)
                .when()
                .get(Roots.GetBookingById);
        return response;
    }
    public static Response updateBooking(BookingPojo payload,int id){
        Response response= given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie","token="+token)
                .header("Authorization ","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body(payload)
                .when()
                .put(Roots.UpdateBooking+id);
        return response;
    }

    public static Response partialupdateBooking(BookingPojo payload,int id){
        Response response= given()
                .header("Accept", "application/json")
                .header("Cookie","token="+token)
                .header("Authorization ","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body(payload)
                .when()
                .patch(Roots.PartialUpdateBooking+id);
        return response;
    }
    public static Response deleteBooking(int id){
        Response response= given()
                .contentType(ContentType.JSON)
                .header("Content-Type","application/json")
                .header("Authorization ","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .delete(Roots.DeleteBooking+id);
        return response;
    }

    public static Response GetBookingAfterdelete(int id){
        Response response= given()
                .pathParam("id", id)
                .when()
                .get(Roots.GetBookingById);
        return response;
    }





}
