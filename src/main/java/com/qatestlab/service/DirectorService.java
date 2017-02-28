package com.qatestlab.service;

import com.qatestlab.model.Employee;
import com.qatestlab.model.ExternalEmployee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.PositionName;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by APopichenko on 22.02.2017.
 */
public interface DirectorService {
    public void grantTasksToEmployee(Set<Employee> employees,Set<ExternalEmployee> externalEmployees, Map<PositionName, String> tasks, int weekPerMonth); //назначить задачи на сотрудника
    public void grantTasksToExternalEmployee(Set<ExternalEmployee> externalEmployees, Map<PositionName, String> tasks, int weekPerMonth); //назначить задачи на внешнего сотрудника
    public void checkIfEmployeeIsFree(Set<Employee> employees, Map<PositionName, String> tasks, int weekPerMonth);
    public void checkIfExternalEmployeeIsFree(Set<ExternalEmployee> employees, Map<PositionName, String> tasks, int weekPerMonth);
    public ExternalEmployee createNewExternalEmployee(Map<PositionName, String> tasks,int weekPerMonth); //Взять на работу нового внешнего сотрудника
    public Set<ExternalEmployee> getExternalEmployees();
}
