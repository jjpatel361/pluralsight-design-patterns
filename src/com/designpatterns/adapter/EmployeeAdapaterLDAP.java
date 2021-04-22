package com.designpatterns.adapter;

public class EmployeeAdapaterLDAP implements Employee {
    private EmployeeLDAP instance;

    public EmployeeAdapaterLDAP(EmployeeLDAP employeeLDAP) {
        this.instance = employeeLDAP;
    }

    @Override
    public String getFirstName() {
        // remember employeeLDAP has full name and no
        // first name last name. this is where the adapter magic comes in to play
        return this.instance.fullName.split(" ")[0];
    }

    @Override
    public String getLastName() {
        return this.instance.fullName.split(" ")[1];
    }

    @Override
    public Integer getAge() {
        return Integer.valueOf(this.instance.age);
    }
}
