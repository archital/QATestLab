package com.qatestlab;


import com.qatestlab.ServiceImpl.EmployeeImpl;
import com.qatestlab.model.Employee;
import com.qatestlab.service.EmployeeService;

import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by APopichenko on 06.01.2017.
 */

public class Application {

    //Список сотрудников и их ролей
    private static Set<Employee> employeeList;
    private static EmployeeService employeeService;
    //10 - 100 сотрудников (задаем случайно)
   static final int AMOUNT_EMPLOYEES_IN_COMPANY = new SecureRandom().nextInt((100 - 10) + 1)+10;
    //8-ми часовый рабочий день
    static final int SCHEDULE_HOURS_PER_MONTH = 40;





    public static void main(String[] args) throws Exception {
        //деплоим приложение
        employeeService = new EmployeeImpl();
        //возвращаем список сотрудников и их должности
        employeeList = employeeService.createEmployees(AMOUNT_EMPLOYEES_IN_COMPANY, SCHEDULE_HOURS_PER_MONTH);

        //выводим в консоль список сотрудников и их должности
        System.out.println(employeeList.size());
        for (Iterator i = employeeList.iterator(); i.hasNext(); ) {
            System.out.println(i.next().toString());
        }

    }
}
