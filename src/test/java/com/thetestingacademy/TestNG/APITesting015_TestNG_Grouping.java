package com.thetestingacademy.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting015_TestNG_Grouping {
    @Test(groups = {"sanity", "qa", "preprod"})
    public void SanityRun() {
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"qa", "preprod", "reg"})
    public void RegRun() {
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test(groups = {"dev","stage"})
    public void SmokeRun(){
        System.out.println("smoke");
        Assert.assertTrue((false));
    }

    @Test(groups = {"sanity","qa","preprod"})
    public void sanityRun1(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"qa","preprod","reg"})
    public void RegRun2(){
        System.out.println("Reg");
        System.out.println("preprod");
        Assert.assertTrue(true);
    }
}
