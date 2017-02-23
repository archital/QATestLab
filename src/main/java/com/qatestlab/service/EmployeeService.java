package com.qatestlab.service;

import com.qatestlab.exceptions.ExternalEmployeeException;
import com.qatestlab.model.Employee;
import com.qatestlab.model.Position;

import java.util.Map;
import java.util.Set;

/**
 * Created by APopichenko on 22.02.2017.
 */
public interface EmployeeService {
    public Set<Employee> findAllEmployees();
    public Set<Employee> createEmployees(int randomCountOfEmployees, int hoursPerDay);
    public Set<Position> setRandomPosition() throws ExternalEmployeeException;
    public void taskExecution(String task);
}
