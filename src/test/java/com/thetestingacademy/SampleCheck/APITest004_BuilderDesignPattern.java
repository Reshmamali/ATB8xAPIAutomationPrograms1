package com.thetestingacademy.SampleCheck;

public class APITest004_BuilderDesignPattern{
        public APITest004_BuilderDesignPattern step1(){
            System.out.println("Step 1 is started");
            System.out.println("Step 1 is done");
            return this;
        }

        public APITest004_BuilderDesignPattern step2(){
            System.out.println("Step 2 is started");
            System.out.println("Step 2 is done");
            return this;
        }

        public APITest004_BuilderDesignPattern step3(String name){
            System.out.println("Step 3 is started");
            System.out.println("Step 3 is done");
            System.out.println("My name is ->" + name);
            return this;
        }

    public static void main(String[] args) {
        APITest004_BuilderDesignPattern bp = new APITest004_BuilderDesignPattern();
        bp.step1().step2().step3("Reshma");

    }
}
