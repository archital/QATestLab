package com.qatestlab.service;



import com.qatestlab.model.Employee;
import com.qatestlab.model.ExternalEmployee;

import java.util.Set;

/**
 * Created by APopichenko on 23.02.2017.
 */
public interface AccountmentService {
    public float calculateSalary (Set<Employee> employees, Set<ExternalEmployee> externalEmployees);
    public float getTotalMonthSalary ();
}
