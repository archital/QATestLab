package com.qatestlab.service;



import com.qatestlab.model.Employee;

import java.util.Set;

/**
 * Created by APopichenko on 23.02.2017.
 */
public interface Accountment {
    public void paySalary (Set<Employee> employees);
}
