package com.bhushanchoudhary.Tests.CRUD;

import com.bhushanchoudhary.Base.BaseTest;
import com.bhushanchoudhary.Endpoints.APIConstants;

import com.bhushanchoudhary.POJOS.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import static org.assertj.core.api.Assertions.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class testCreateBookingTest extends BaseTest {



        @Test(groups = "Smoke")
        @Owner("Bhushan Chodhary")
        @Severity(SeverityLevel.NORMAL)
        @Description("TC1 - Verify that booking can be created")
        public void createBooking(){

                requestspecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

                response = RestAssured.given(requestspecification).when().body(payloadManager.createPayloadBookingAsString()).log().all().post();

                validatableResponse = response.then().log().all();
                validatableResponse.statusCode(200);
                //DeSerelization
                BookingResponse bookingResponse= payloadManager.bookingResponseJava(response.asString());
                System.out.println(bookingResponse);
               // AssertJ
                assertThat(bookingResponse.getBookingid()).isNotNull();
                assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
                assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Bhushan");

                assertAction.verifyStatusCode(response,200);


    }

        @Test(groups = "Smoke")
        @Owner("Bhushan Chodhary")
        @Severity(SeverityLevel.NORMAL)
        @Description("TC1 - Verify that booking can be created")
        public void createBookingNegative(){

                requestspecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

                response = RestAssured.given(requestspecification).when().body(payloadManager.createInvalildPayloadBookingAsString()).log().all().post();

                validatableResponse = response.then().log().all();
                validatableResponse.statusCode(500);




                assertAction.verifyStatusCode(response,500);


        }


}
