package com.bhushanchoudhary.Tests.Integration;

import com.bhushanchoudhary.Base.BaseTest;
import com.bhushanchoudhary.Endpoints.APIConstants;
import com.bhushanchoudhary.Modules.PayloadManager;
import com.bhushanchoudhary.POJOS.Booking;
import com.bhushanchoudhary.POJOS.BookingResponse;
import com.bhushanchoudhary.Utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.requestSpecification;
import static org.assertj.core.api.Assertions.assertThat;

public class TestCaseIntegrationFlow extends BaseTest {

    // Integration Tests step by step:-
    //1. Create A Booking, Create A Token
    //2. Get Booking
    //3. Update the Booking
    //4. Delete the Booking

    @Test(groups="Integration", priority = 1)
    @Owner("Bhushan")
    @Description("TC1 Verifying the Booking is creating or not")
    public void createBooking(ITestContext iTestContext){
        iTestContext.setAttribute("token", getToken());
        Assert.assertTrue(true);

        requestspecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestspecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Dsesrlization
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());

        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Bhushan");

        assertAction.verifyStatusCode(response,200);









    }

    @Test(groups="Integration", priority = 2)
    @Owner("Bhushan")
    @Description("TC2 Verifying the Booking Details which is created")
    public void getBooking(ITestContext iTestContext)
    {
        String basePath = iTestContext.getAttribute("bookingid").toString();
        requestspecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+basePath);

        response = RestAssured.given(requestspecification)
                        .when().get();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponseFromJSON(response.asString());


        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo(PropertyReader.readkey("Booking.firstname"));

        assertAction.verifyStatusCode(response,200);



    }





    @Test(groups = "Integration", priority = 3)
    @Owner("Bhushan")
    @Description("TC3 Updating and verifying the Booking Details ")
    public void updateBooking(ITestContext iTestContext){

        String token= (String) iTestContext.getAttribute("token");
        Integer bookingid= (Integer) iTestContext.getAttribute("bookingid");
        String basePathPUTPATCH = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathPUTPATCH);


        requestspecification.basePath(basePathPUTPATCH);

        response = RestAssured.given(requestspecification).cookie("token", token)
                .when().body(payloadManager.updatePayloadBookingAsString()).put();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponseFromJSON(response.asString());


        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Mahesh");

        assertAction.verifyStatusCode(response,200);








    }

   @Test(groups="Integration", priority = 4)
    @Owner("Bhushan")
    @Description("TC4 Deleting the booking detials")
    public void deleteBooking(ITestContext iTestContext){
        System.out.println("Token--"+iTestContext.getAttribute("token"));

        String token= (String) iTestContext.getAttribute("token");
        Integer bookingid= (Integer) iTestContext.getAttribute("bookingid");
        String basePathDelete = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathDelete);

        requestspecification.basePath(basePathDelete);

        response = RestAssured.given(requestspecification).cookie("token", token)
                .when().delete();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(201);

    }
}
