package com.thetestingacademy.RESTAssuredBasics.GET;

public class APITesting004_GET {
    public void step1(){
        System.out.println("Step 1");
    }
    public void step2(){
        System.out.println("Step 2");
    }

    public void step3(String name){
        System.out.println("Step 3" + name);
    }

    public static void main(String[] args) {
        APITesting004_GET np = new APITesting004_GET();
        np.step1();
        np.step2();
        np.step3(" Reshma");

    }
}
