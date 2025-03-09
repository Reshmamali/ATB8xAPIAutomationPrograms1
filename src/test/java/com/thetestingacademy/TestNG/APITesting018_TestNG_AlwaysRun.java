package com.thetestingacademy.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018_TestNG_AlwaysRun {

    @Test
    public void t1() {
        System.out.println("testcase 1");
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = false)
    public void t2() {
        System.out.println("testcase 2");
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)
    public void t3() {
        System.out.println("testcase 3");
        Assert.assertTrue(true);
    }
}
