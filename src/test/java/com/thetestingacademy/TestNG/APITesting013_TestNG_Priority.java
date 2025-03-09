package com.thetestingacademy.TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting013_TestNG_Priority {
    @Test(priority = 1)
    public void t1() {
        System.out.println("testcase 1");
    }

    @Test(priority = 3)
    public void t2() {
        System.out.println("testcase 3");
    }

    @Test(priority = 2)
    public void t3() {
        System.out.println("testcase 2");
    }
}
