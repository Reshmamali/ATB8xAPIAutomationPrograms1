package com.thetestingacademy.PayloadManagement;

public class Person {
    private String name;
    private int age;

    Person(){
        System.out.println("DC");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
