package com.qatestlab;

import com.qatestlab.ServiceImpl.AccountmentServiceImpl;
import com.qatestlab.ServiceImpl.DirectorServiceImpl;
import com.qatestlab.model.Employee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.PositionName;
import com.qatestlab.service.AccountmentService;
import com.qatestlab.service.DirectorService;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by APopichenko on 23.02.2017.
 */
public class WorkEmulation {

    private Set<Employee> employeeList;
    private Employee requiredAccountant;
    private  Map<PositionName,String> taskList;
    private DirectorService directorService = new DirectorServiceImpl();
    private AccountmentService accountmentService = new AccountmentServiceImpl();

    protected WorkEmulation(Set<Employee> employeeList, Employee requiredAccountant, Map<PositionName,String> taskList) {
        this.employeeList = employeeList;
        this.requiredAccountant = requiredAccountant;
        this.taskList = taskList;

        //����� ����� ����������� ������ ��������

     StartToWork(employeeList,requiredAccountant,taskList);
    }

    private void StartToWork(Set<Employee> employeeList, Employee requiredAccountant, Map<PositionName,String> taskList){

        //������ ���� �����������
        //    for (Map.Entry<Person, Set<Position>> person : personList.entrySet()) person.getKey().start();

        //�������� �������� � ������� ������
        for (int i = 0; i < Application.WORKING_WEEKS; i++) {
            for (int j = 0; j < Application.SCHEDULE_HOURS_PER_WEEK; j++) {
                directorService.grantTasksToEmployee(employeeList,taskList);
            }

            //� ����� ������ ������������ �������
         //   accountmentService.payWeekSalary(personList, PersonController.INSTANCE.getFreelancers());
        }


        for (Iterator i = employeeList.iterator(); i.hasNext(); ) {
            System.out.println("���������� - ���� - ������");
            System.out.println(i.next().toString());
        }

      //  ReportController.INSTANCE.runReportController(); //������� �����

        //��������� ���� ����������� � ����� ������
       // for (Map.Entry<Person, Set<Position>> person : personList.entrySet()) person.getKey().setStopWork(true);


    }

}
