package com.thetestingacademy.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting020_SoftAndHardAssertions {

    @Test
    public void HardAssert(){
        System.out.println("Stating a program");
        Assert.assertTrue(false);
        System.out.println("End of the program");
    }

    @Test
    public void SoftAssert(){
        System.out.println("Start");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("end");
    }
}
