package com.qatestlab;


import com.qatestlab.ServiceImpl.EmployeeImpl;
import com.qatestlab.exceptions.FreeAccountantNotFoundException;
import com.qatestlab.exceptions.RequiredlEmployeesNotFoundException;
import com.qatestlab.model.Employee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.IsSalaryPerHour;
import com.qatestlab.model.enums.PositionName;
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
    private static Position position = null;
    private static Employee employee = null;
    private static int countOfAcountant = 0;

    //10 - 100 сотрудников (задаем случайно)
   static final int AMOUNT_EMPLOYEES_IN_COMPANY = new SecureRandom().nextInt((100 - 10) + 1)+10;
    //8-ми часовый рабочий день
    static final int SCHEDULE_HOURS_PER_MONTH = 40;





    public static void main(String[] args) throws Exception {

     Application application = new Application();
        application.init();
    }

   public void init (){
        employeeService = new EmployeeImpl();


        //создаем сотрудников и их должности
         employeeService.createEmployees(AMOUNT_EMPLOYEES_IN_COMPANY, SCHEDULE_HOURS_PER_MONTH);
       //возвращаем список сотрудников и их должности
       try {
           employeeList = employeeService.findAllEmployees();
       } catch (RequiredlEmployeesNotFoundException e) {
           e.printStackTrace();
       }
       //берем одного бухгалтера, который будет начислять зарплату
       try {
           employee = searchAccountant(employeeList);
       } catch (FreeAccountantNotFoundException e) {
           e.printStackTrace();
       }


       //выводим в консоль список сотрудников и их должности
        System.out.println(employeeList.size());
        for (Iterator i = employeeList.iterator(); i.hasNext(); ) {
            System.out.println(i.next().toString());
        }
    }

    //Метод возвращает одного свободного бухгалтера
    public Employee searchAccountant (Set<Employee> employeeList) throws FreeAccountantNotFoundException {


        position = new Position(IsSalaryPerHour.NO,100,PositionName.Accountment);


        for (Iterator i = employeeList.iterator(); i.hasNext()||countOfAcountant==1; ) {

            employee = (Employee) i.next();
            if (employee.isBusy() == false && employee.getPositionSet().contains(position)) {
                System.out.println("Accountant for salary calculation:" + employee.toString());
                countOfAcountant++;
                return employee;
            }

        }
        if(employee == null) {
            throw new FreeAccountantNotFoundException("There is no free an accountant in random set of employees");
        }
        return employee;
    }
}
