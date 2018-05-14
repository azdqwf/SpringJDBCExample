package com.danila.customer.model;

public class Customer {
    int custId;
    String name;
    int age;


    public Customer(int custId, String name, int age) {
        this.custId = custId;
        this.name = name;
        this.age = age;
    }

    public int getCustId() {
        return custId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", name=" + name +
                ", age=" + age +
                '}';
    }
}
