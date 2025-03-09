package com.thetestingacademy.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting016_TestNG_dependsOnMethod {
    @Test
    public void t1() {
        System.out.println("testcase 1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "t1")
    public void t2() {
        System.out.println("testcase 3");
        Assert.assertTrue(3<1);
    }

    @Test(dependsOnMethods = "t2" )
    public void t3() {
        System.out.println("testcase 2");
        Assert.assertTrue(8<10);
    }
}
