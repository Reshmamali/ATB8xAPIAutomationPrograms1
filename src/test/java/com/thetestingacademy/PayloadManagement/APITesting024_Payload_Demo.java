package com.thetestingacademy.PayloadManagement;

public class APITesting024_Payload_Demo {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(20);
        person.setName("reshma");
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
