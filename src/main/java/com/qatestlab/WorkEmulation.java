package com.qatestlab;

import com.qatestlab.exceptions.RequiredlEmployeesNotFoundException;
import com.qatestlab.model.Employee;
import com.qatestlab.model.ExternalEmployee;
import com.qatestlab.model.enums.PositionName;
import com.qatestlab.service.AccountmentService;
import com.qatestlab.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by APopichenko on 23.02.2017.
 */
@Component
public class WorkEmulation {

    private Set<Employee> employeeList;
    private Set<ExternalEmployee> externalEmployeeList = new HashSet();
    private Employee requiredAccountant;
    private  Map<PositionName,String> taskList;
    private float salaryPerWeek;
    private float totalSalaryPerMonth;
    @Autowired
    private DirectorService directorService;
    @Autowired
    private AccountmentService accountmentService;
    @Autowired
    private ReportGenerator reportGenerator;
    private StringBuilder stringBuilder = new StringBuilder();


    public Set<ExternalEmployee> getExternalEmployeeList() {
        return externalEmployeeList;
    }

    public void setExternalEmployeeList(Set<ExternalEmployee> externalEmployeeList) {
        this.externalEmployeeList = externalEmployeeList;
    }

    public void StartToWork() throws RequiredlEmployeesNotFoundException, IOException {

        //Перед началом месяца отчет бухгалтера практически пуст
        stringBuilder.append("-----====REPORT====-----------");
        stringBuilder.append('\n');
        stringBuilder.append("=====================================================");

        //компания работает в течении месяца
        for (int i = 0; i < Application.WORKING_WEEKS; i++) {
            for (int j = 0; j < Application.SCHEDULE_HOURS_PER_WEEK; j++) {
                directorService.grantTasksToEmployee(employeeList, getExternalEmployeeList(), getTaskList(), (i+1));
                setTaskList(Application.initTaskList());
               setExternalEmployeeList(directorService.getExternalEmployees());
            }

            //в конце недели бухгалтер подсчитывает зарплаты
         this.salaryPerWeek = accountmentService.calculateSalary(employeeList,directorService.getExternalEmployees());
            //записывает в отчет информацию по зарплатам за неделю
             stringBuilder.append(reportGenerator.writeWeekReportToFile(employeeList,directorService.getExternalEmployees(),(i+1)));
        }
        //в конце месяца создает отчет и записывем его в файл
        this.totalSalaryPerMonth = accountmentService.getTotalMonthSalary();
        stringBuilder.append(reportGenerator.writeMonthReportToFile(totalSalaryPerMonth,employeeList.size(),directorService.getExternalEmployees().size()));
        reportGenerator.writeReportToFile(stringBuilder.toString());
    }



    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
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


    public WorkEmulation() {
    }



}
