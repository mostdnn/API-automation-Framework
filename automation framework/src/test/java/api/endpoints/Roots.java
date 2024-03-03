package api.endpoints;


public class Roots {

    public static String basURL="https://restful-booker.herokuapp.com";
    //CreateToken
    public static String CreateToken=basURL+"/auth";
    //GetBookingIds

    public static String GetBookingIds=basURL+"/booking";
    //Get booking by id
    public static String GetBookingById=basURL+"/booking/{id}";
    //CreateBooking
    public static String CreateBooking=basURL+"/booking";
    //UpdateBooking
    public static String UpdateBooking =basURL+"/booking/";
    //PartialUpdateBooking
    public static String PartialUpdateBooking =basURL+"/booking/";
    //DeleteBooking
    public static String DeleteBooking =basURL+"/booking/";
    //Ping - HealthCheck
    public static String Ping =basURL+"/ping";





}
