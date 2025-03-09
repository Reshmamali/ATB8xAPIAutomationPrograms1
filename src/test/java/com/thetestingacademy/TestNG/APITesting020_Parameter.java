package com.thetestingacademy.TestNG;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Parameter;

public class APITesting020_Parameter {
    @Parameters("browser")
    @Test
    public void t1(String value) {
        System.out.println("testcase 1");
        Assert.assertTrue(true);

        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start my testing on chrome");
        } else if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start my testing on firefox");
        } else{
            System.out.println("Browser is not selected");
        }
    }
}
