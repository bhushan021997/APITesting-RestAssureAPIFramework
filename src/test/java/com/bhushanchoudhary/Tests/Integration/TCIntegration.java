package com.bhushanchoudhary.Tests.Integration;

import com.bhushanchoudhary.Base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TCIntegration extends BaseTest {
// Integration Tests step by step:-
    //1. Create A Booking, Create A Token
    //2. Get Booking
    //3. Update the Booking
    //4. Delete the Booking

    @Test(groups="Integration", priority = 1)
    @Owner("Bhushan")
    @Description("TC1 Verifying the Booking is creating or not")
    public void createBooking(){
        Assert.assertTrue(true);




    }

    @Test(groups="Integration", priority = 2)
    @Owner("Bhushan")
    @Description("TC2 Verifying the Booking Details which is created")
    public void getBooking(){
        Assert.assertTrue(true);




    }

    @Test(groups="Integration", priority = 3)
    @Owner("Bhushan")
    @Description("TC3 Updating and verifying the Booking Details ")
    public void updateBooking(){
        Assert.assertTrue(true);




    }

    @Test(groups="Integration", priority = 4)
    @Owner("Bhushan")
    @Description("TC4 Deleting the booking detials")
    public void deleteBooking(){
        Assert.assertTrue(true);




    }







}

