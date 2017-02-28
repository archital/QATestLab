package com.qatestlab.service;

import com.qatestlab.model.Employee;
import com.qatestlab.model.ExternalEmployee;
import com.qatestlab.model.enums.PositionName;

import java.util.Map;
import java.util.Set;

/**
 * Created by APopichenko on 22.02.2017.
 */
public interface DirectorService {
    public void grantTasksToEmployee(Set<Employee> employees,Set<ExternalEmployee> externalEmployees, Map<PositionName, String> tasks, int weekPerMonth); //назначить задачи на сотрудников
    public void grantTasksToExternalEmployee(Set<ExternalEmployee> externalEmployees, Map<PositionName, String> tasks, int weekPerMonth); //назначить задачи на внешнего сотрудников
    public void checkIfEmployeeIsFree(Set<Employee> employees, Map<PositionName, String> tasks, int weekPerMonth); //метод проверки, есть ли свободный внутренний сотрудник
    public void checkIfExternalEmployeeIsFree(Set<ExternalEmployee> employees, Map<PositionName, String> tasks, int weekPerMonth); //метод проверки, есть ли свободный внешний сотрудник
    public ExternalEmployee createNewExternalEmployee(Map<PositionName, String> tasks,int weekPerMonth); //Взять на работу нового внешнего сотрудника
    public Set<ExternalEmployee> getExternalEmployees(); //метод возвращает список внешних сотрудников
}
