package com.bhushanchoudhary.Base;

import com.bhushanchoudhary.Actions.AssertActions;
import com.bhushanchoudhary.Endpoints.APIConstants;
import com.bhushanchoudhary.Modules.PayloadManager;
import com.bhushanchoudhary.POJOS.BookingResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    //BaseTest is Father and ramining is son

    public RequestSpecification requestspecification;
    public AssertActions assertAction;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setConfig(){


        System.out.println("Before Test");
        payloadManager = new PayloadManager();
        assertAction = new AssertActions();
        requestspecification = new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();
    }

    public String getToken() {

//Setup the URl's
        requestspecification = RestAssured.given().baseUri(APIConstants.BASE_URL)
                .basePath(APIConstants.AUTH_URL);

//Setting up the payload
        String payload = payloadManager.setPayLoad();


//Getting the response
        response= requestspecification.contentType(ContentType.JSON)
                .body(payload)
                .when().post();

//Extracting the token via Dsaer
        String token = payloadManager.getToken(response.asString());

//Verify
        return token;





    }





}
