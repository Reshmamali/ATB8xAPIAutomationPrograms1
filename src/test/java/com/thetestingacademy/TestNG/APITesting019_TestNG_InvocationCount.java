package com.thetestingacademy.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting019_TestNG_InvocationCount {
    @Test(invocationCount = 5)
    public void t1() {
        System.out.println("testcase 1");
        Assert.assertTrue(true);
    }

}
