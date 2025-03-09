package com.thetestingacademy.TestNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting012_TestNG_Beforetest {
    @BeforeTest
    public void t1() {
        System.out.println("testcase 1");
    }

    @BeforeTest
    public void t2() {
        System.out.println("testcase 3");
    }

    @Test
    public void t3() {
        System.out.println("testcase 2");
    }
}
