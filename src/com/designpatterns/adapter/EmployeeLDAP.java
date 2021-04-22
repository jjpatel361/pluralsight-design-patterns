package com.designpatterns.adapter;

public class EmployeeLDAP  {

    public String fullName;
    public String email;
    public String age;

    public EmployeeLDAP(String fullName, String email, String ageStr) {
        this.fullName = fullName;
        this.email = email;
        this.age = ageStr;
    }
}
