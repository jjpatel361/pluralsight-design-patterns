package com.designpatterns.adapter;


import java.util.ArrayList;

public class AdapterDemo {

    public static void main(String[] args) {
        /*
        *
        * adapter  falls under structural pattern
        *
        * - use it to help communicate between two systems
        *   where one is either a legacy system with lots of dependency
        *   where the client is outside our system control say packaged inside a framework or lib or another part
        *    of monolith
        * - adapter acts as an interface between two objects
        * - critical components are
        *       - Source Object the one that needs to be fitted. usually the new one
        *       - SinkAdapterSource an Adapter
        *       - Sink Object the legacy object that can't be changed
        *
        * adapter
        * - don't add functionality to adapter
        * - don't include business logic just field mappings
        * - mostly retro fitted to make different objects work together
        * */

        ArrayList<Employee> employeeList = new ArrayList<>();
        EmployeeCSV employeeA = new EmployeeCSV("Jay", "Patel", "demo@gmail.com", 29);
        employeeList.add(employeeA);
        // Employee is a legacy object being used in entire system.
        // say we have a new system for importing Employees via a Ldap system like outlook
        EmployeeLDAP employeeLDAP = new EmployeeLDAP("Jay Patel", "demo@gmail.com", "29");
        // we cannot directly add LDAP object to the employee list.
        // LDAP doesn't implement the interface and hence we need some sort of adapter that takes in
        // interesting takes
        //   LDAP doesn't implement Employee class the Adapter does
        //   Adapter also takes care of contract matching with data types
        //      e.g. age string to int conversion etc.
        //      e.g. LDAP doesn't have firstname and last name but adapter takes care of it.
        // you can have multiple adapters working say EmployeeAdapterCSV that takes in employee record from CSV
        // and makes an employee object for you.
        employeeList.add(new EmployeeAdapaterLDAP(employeeLDAP));


        System.out.println(employeeList);

    }
}
