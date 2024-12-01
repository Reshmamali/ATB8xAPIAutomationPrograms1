package com.thetestingacademy.SampleCheck;

public class APITest003_NoDesignPattern {
        public void step1(){
            System.out.println("test1");
        }

        public void step2(){
            System.out.println("test2");
        }

        public void step3(String name){
            System.out.println("test3");
        }

    public static void main(String[] args) {
        APITest003_NoDesignPattern np = new APITest003_NoDesignPattern();
            np.step1();
            np.step2();
            np.step3("Reshma");

        //np.step1().step2().step3("Reshma");

    }
}
