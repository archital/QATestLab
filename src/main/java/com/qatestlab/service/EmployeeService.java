package com.qatestlab.service;

import com.qatestlab.exceptions.ExternalEmployeeException;
import com.qatestlab.exceptions.RequiredlEmployeesNotFoundException;
import com.qatestlab.model.Employee;
import com.qatestlab.model.Position;

import java.util.Set;

/**
 * Created by APopichenko on 22.02.2017.
 */

public interface EmployeeService {
    public Set<Employee> findAllEmployees() throws RequiredlEmployeesNotFoundException; //Метод возвращает список сотрудников
    public void createEmployees(int randomCountOfEmployees, int hoursPerMonth); //Метод инициализирует случайное количество объектов сотрудник (от 1 до 100)
    public Set<Position> setRandomPosition() throws ExternalEmployeeException; //Метод инициализирует случайное количество объектов позиция (от 1 до 5)
    public Set<Employee> checkRandomEmployeesList(Set<Employee> employees) throws RequiredlEmployeesNotFoundException; //Метод проверяет, есть ли обязательные сотрудники с позициями (Менеджер, Директор, Бухгалтер)
}
