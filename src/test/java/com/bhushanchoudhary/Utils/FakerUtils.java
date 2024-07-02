package com.bhushanchoudhary.Utils;

import com.github.javafaker.Faker;


public class FakerUtils
{


    Faker faker;


    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {

        return faker.name().lastName();
    }

}
