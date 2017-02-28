package com.qatestlab;

import com.qatestlab.ServiceImpl.AccountmentServiceImpl;
import com.qatestlab.ServiceImpl.DirectorServiceImpl;
import com.qatestlab.exceptions.RequiredlEmployeesNotFoundException;
import com.qatestlab.model.Employee;
import com.qatestlab.model.ExternalEmployee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.PositionName;
import com.qatestlab.service.AccountmentService;
import com.qatestlab.service.DirectorService;
import com.qatestlab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by APopichenko on 23.02.2017.
 */
@Component
public class WorkEmulation {

    private Set<Employee> employeeList;
    private Set<ExternalEmployee> externalEmployeeList = new HashSet();;
    private Employee requiredAccountant;
    private  Map<PositionName,String> taskList;
    private float salaryPerWeek;
    private float totalSalaryPerMonth;
    @Autowired
    private DirectorService directorService;
    @Autowired
    private AccountmentService accountmentService;


    public Set<ExternalEmployee> getExternalEmployeeList() {
        return externalEmployeeList;
    }

    public void setExternalEmployeeList(Set<ExternalEmployee> externalEmployeeList) {
        this.externalEmployeeList = externalEmployeeList;
    }

    public void StartToWork() throws RequiredlEmployeesNotFoundException {

        //Компания работает в течении месяца
        for (int i = 0; i < Application.WORKING_WEEKS; i++) {
            for (int j = 0; j < Application.SCHEDULE_HOURS_PER_WEEK; j++) {
                directorService.grantTasksToEmployee(employeeList, getExternalEmployeeList(), getTaskList(), (i+1));
                setTaskList(Application.initTaskList());
               setExternalEmployeeList(directorService.getExternalEmployees());
            }

            //в конце недели бухгалтер подсчитывает зарплаты
         this.salaryPerWeek = accountmentService.calculateSalary(employeeList,directorService.getExternalEmployees());
            System.out.println("TotalWeekSalary for week # "+(i+1)+" "+ salaryPerWeek);

        }
        //в конце метода генерируем отчет
        this.totalSalaryPerMonth = accountmentService.getTotalMonthSalary();
        System.out.println("TotalSalaryPerMonth "+ totalSalaryPerMonth);
    }


    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getRequiredAccountant() {
        return requiredAccountant;
    }

    public void setRequiredAccountant(Employee requiredAccountant) {
        this.requiredAccountant = requiredAccountant;
    }

    public Map<PositionName, String> getTaskList() {
        return taskList;
    }

    public void setTaskList(Map<PositionName, String> taskList) {
        this.taskList = taskList;
    }

    public DirectorService getDirectorService() {
        return directorService;
    }

    public void setDirectorService(DirectorService directorService) {
        this.directorService = directorService;
    }

    public AccountmentService getAccountmentService() {
        return accountmentService;
    }

    public void setAccountmentService(AccountmentService accountmentService) {
        this.accountmentService = accountmentService;
    }

    public WorkEmulation() {
    }



}
