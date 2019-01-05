package com.example.nh.sqliteapp;

import java.io.Serializable;

public class Employee  implements Serializable {
    private int id;
    private String name;
    private String address;
    private double salary;
    private String jop;

    public Employee(int id,String name, String address, double salary, String jop) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jop = jop;
    }

    public Employee(String name, String address, double salary, String jop) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jop = jop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }

}
