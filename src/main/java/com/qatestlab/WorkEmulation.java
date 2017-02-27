package com.qatestlab;

import com.qatestlab.ServiceImpl.AccountmentServiceImpl;
import com.qatestlab.ServiceImpl.DirectorServiceImpl;
import com.qatestlab.model.Employee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.PositionName;
import com.qatestlab.service.AccountmentService;
import com.qatestlab.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by APopichenko on 23.02.2017.
 */
@Component
public class WorkEmulation {

    private Set<Employee> employeeList;
    private Employee requiredAccountant;
    private  Map<PositionName,String> taskList;
    @Autowired
    private DirectorService directorService;
    @Autowired
    private AccountmentService accountmentService;


    public void StartToWork(){

        //Компания работает в течении месяца
        for (int i = 0; i < Application.WORKING_WEEKS; i++) {
            for (int j = 0; j < Application.SCHEDULE_HOURS_PER_WEEK; j++) {
                directorService.grantTasksToEmployee(employeeList, getTaskList(), (i+1));
                setTaskList(Application.initTaskList());
            }

            System.out.println("Week number " + (i+1));
            System.out.println();
            for (Iterator iter = employeeList.iterator(); iter.hasNext(); ) {
                System.out.println("Сотрудники:");
                System.out.println(iter.next().toString());
            }
            //в конце недели выплачиается зарплат
            //   accountmentService.payWeekSalary(personList, PersonController.INSTANCE.getFreelancers());
        }



        //  ReportController.INSTANCE.runReportController(); //создаем отчет

        //остановка всех сотрудников в конце месяца
        // for (Map.Entry<Person, Set<Position>> person : personList.entrySet()) person.getKey().setStopWork(true);


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
