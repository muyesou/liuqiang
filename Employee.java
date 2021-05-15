package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    int happy;
    List<Employee> after=new ArrayList<>();

    public Employee(int happy) {
        this.happy = happy;
    }
}
