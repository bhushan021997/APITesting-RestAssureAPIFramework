package com.bhushanchoudhary.Modules;

import com.bhushanchoudhary.POJOS.*;
import com.google.gson.Gson;




public class PayloadManager{

    Gson gson;





    public String createPayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Bhushan");
        booking.setLastname("Choudhary");
        booking.setTotalprice(1111);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2023-06-01");
        bookingdates.setCheckout("2023-06-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        gson = new Gson();


        return gson.toJson(booking);


    }

    public String createInvalildPayloadBookingAsString() {


        return "{}";


    }

    public String updatePayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Mahesh");
        booking.setLastname("Paradkar");
        booking.setTotalprice(1111);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-06-01");
        bookingdates.setCheckout("2024-06-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("BreakFast");
        gson = new Gson();


        return gson.toJson(booking);


    }

    public BookingResponse bookingResponseJava(String responseString) {

        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;


    }

    public String setPayLoad() {

        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayload = gson.toJson(auth);
        System.out.println(jsonPayload);
        return jsonPayload;


    }

    public String getToken(String tokenResponse) {

        gson = new Gson();
        //Response (JSON String) -->> Object
        //Deserialization
        TokenResponse tokenresponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenresponse1.getToken();


    }

    public Booking getResponseFromJSON(String getResponse) {
        gson = new Gson();
        //DSERV
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;
    }




    // Payload

}