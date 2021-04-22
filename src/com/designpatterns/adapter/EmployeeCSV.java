package com.designpatterns.adapter;

public class EmployeeCSV implements Employee {

    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public EmployeeCSV(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public Integer getAge() {
        return age;
    }
}
