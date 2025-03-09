package com.thetestingacademy.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting017_TestNG_Enabled {
    @Test
    public void t1() {
        System.out.println("testcase 1");
        Assert.assertTrue(true);
    }

    @Test(enabled = true)   // here enabled = false >> you will skip the execution of TC if it is true then it will run
    public void t2() {
        System.out.println("testcase 2");
        Assert.assertTrue(true);
    }

    @Test
    public void t3() {
        System.out.println("testcase 3");
        Assert.assertTrue(true);
    }

}
