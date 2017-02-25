package com.qatestlab.service;

import com.qatestlab.exceptions.ExternalEmployeeException;
import com.qatestlab.exceptions.RequiredlEmployeesNotFoundException;
import com.qatestlab.model.Employee;
import com.qatestlab.model.Position;

import java.util.Map;
import java.util.Set;

/**
 * Created by APopichenko on 22.02.2017.
 */

public interface EmployeeService {
    public Set<Employee> findAllEmployees() throws RequiredlEmployeesNotFoundException;
    public void createEmployees(int randomCountOfEmployees, int hoursPerMonth);
    public Set<Position> setRandomPosition() throws ExternalEmployeeException;
    public Set<Employee> checkRandomEmployeesList(Set<Employee> employees) throws RequiredlEmployeesNotFoundException;
    public void taskExecution(String task);
}
