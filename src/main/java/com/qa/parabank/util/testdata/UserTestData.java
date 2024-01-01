package com.qa.parabank.util.testdata;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserTestData {

    public static Map<String,String> getUserData() {

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHms");
        Faker faker = new Faker();

        String firstName = "Auto_FN"+formatter.format(new Date());
        String lastName = "Auto_LN"+formatter.format(new Date());
        String username = faker.letterify("??????????");

        Map<String,String> userData = new HashMap<>();

        userData.put("firstName",firstName);
        userData.put("lastName",lastName);
        userData.put("address","Cairo");
        userData.put("city","Naser City");
        userData.put("state","Omar Makram");
        userData.put("zipCode","63511");
        userData.put("phone","01142949667");
        userData.put("ssn","123");
        userData.put("username",username);
        userData.put("password","P@ssword");
        userData.put("confirmPassword","P@ssword");

        return userData;
    }

    public static Map<String,String> getPayeeData() {

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHms");

        String firstName = "Auto_Name_"+formatter.format(new Date());

        Map<String,String> payeeData = new HashMap<>();

        payeeData.put("payeeName",firstName);
        payeeData.put("payeeAddress","Egypt");
        payeeData.put("payeeCity","Cairo");
        payeeData.put("payeeState","Naser City");
        payeeData.put("payeeZipCode","63511");
        payeeData.put("payeePhoneNumber","01142949667");
        payeeData.put("accountNumber","123");
        payeeData.put("verifyAccount","123");

        return payeeData;
    }
}
