package com.qatestlab.ServiceImpl;

import com.qatestlab.TasksForExternalEmployees;
import com.qatestlab.model.Employee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.IsSalaryPerHour;
import com.qatestlab.model.enums.PositionName;
import com.qatestlab.service.DirectorService;
import com.sun.javafx.tk.Toolkit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.*;

/**
 * Created by APopichenko on 22.02.2017.
 */
@Service
public class DirectorServiceImpl implements DirectorService {

    private Employee employee;
    private Set<Position> positions;
    private String employeeTask;
    private int spendTime;
    private Map<PositionName, String> tasks = null;
    private TasksForExternalEmployees tasksForExternalEmployees;
    private Set<Position> externalPositions;
    @Autowired
    private Position position;
    private int weekPerMonth;

    @Override
    public void grantTasksToEmployee(Set<Employee> employees, Map<PositionName, String> tasks, int weekPerMonth) {
        this.tasks = tasks;
        this.weekPerMonth = weekPerMonth;


    for (Iterator i = employees.iterator(); i.hasNext();) {
        this.employee = (Employee) i.next();
        this.positions = employee.getPositionSet();

        //Если началась новая неделя, то обнуляем количество часов для работа и добавляем
        if (employee.getWeekPerMonth() < weekPerMonth){
            employee.setHoursPerWeekend(40);
            employee.setIsBusy(false);
            employee.setWeekPerMonth(weekPerMonth);

        };

        for (Position position : positions) {
            //рандомно решаем 1 или 2 часа уйдет на выполнение задачи
            spendTime = new SecureRandom().nextInt((2 - 1) + 1) + 1;

//                if (tasks.containsKey(position.getPositionName())&& (!employee.isBusy())) {
//                      employee.setSpendTime(spendTime);
//                      employee.setCurrentTask(tasks.get(PositionName.Tester));
//                      employee.addTask(tasks.get(PositionName.Tester),weekPerMonth);
//                      tasks.remove(PositionName.Tester);
//                }
//                tasks.containsKey(position.getPositionName())

            if (tasks.containsKey(position.getPositionName()) && position.getPositionName() == PositionName.Tester && (!employee.isBusy())) {
                employee.setSpendTime(spendTime);
                employee.setCurrentTask(tasks.get(PositionName.Tester));
                employee.addTask(tasks.get(PositionName.Tester), weekPerMonth);
                tasks.remove(PositionName.Tester);
            }
            if (tasks.containsKey(position.getPositionName()) && position.getPositionName() == PositionName.Programmer && (!employee.isBusy())) {
                employee.setSpendTime(spendTime);
                employee.setCurrentTask(tasks.get(PositionName.Programmer));
                employee.addTask(tasks.get(PositionName.Programmer), weekPerMonth);
                tasks.remove(PositionName.Programmer);
            }
            if (tasks.containsKey(position.getPositionName()) && position.getPositionName() == PositionName.Designer && (!employee.isBusy())) {
                employee.setSpendTime(spendTime);
                employee.setCurrentTask(tasks.get(PositionName.Designer));
                employee.addTask(tasks.get(PositionName.Designer), weekPerMonth);
                tasks.remove(PositionName.Designer);
            }
            if (tasks.containsKey(position.getPositionName()) && position.getPositionName() == PositionName.Manager && (!employee.isBusy())) {
                employee.setSpendTime(spendTime);
                employee.setCurrentTask(tasks.get(PositionName.Manager));
                employee.addTask(tasks.get(PositionName.Manager), weekPerMonth);
                tasks.remove(PositionName.Manager);
            }
            if (tasks.containsKey(position.getPositionName()) && position.getPositionName() == PositionName.Accountment && (!employee.isBusy())) {
                employee.setSpendTime(spendTime);
                employee.setCurrentTask(tasks.get(PositionName.Accountment));
                employee.addTask(tasks.get(PositionName.Accountment), weekPerMonth);
                tasks.remove(PositionName.Accountment);
            }
        }
    }


        if (!tasks.isEmpty()){
            System.out.println("Executor not foud for such tasks on week #" + weekPerMonth);
            System.out.println(tasks.toString());
        } else if (tasks.isEmpty()) {
            System.out.println("All task were submited");
        }
        //Если еще есть задачи для сотрудников, но все работники заняты,
        //то нанимаем внешнего работника


//            Iterator iterator = tasks.entrySet().iterator();
//            while (iterator.hasNext()) {
//
//                //рандомно решаем 1 или 2 часа уйдет на выполнение задачи
//                spendTime = new SecureRandom().nextInt((2 - 1) + 1)+1;
//                //Если нету нанятого работника на работу свободного
//
//            }
//
//            //рандомно решаем 1 или 2 часа уйдет  на выполнение задачи
//            spendTime = new SecureRandom().nextInt((2 - 1) + 1)+1;
//            externalPositions = new HashSet<>();
//          //  position.setPositionName(PositionName.ExternalEmployee);
//            position.setSalary(400);
//            position.setIsSalaryPerHour(IsSalaryPerHour.YES);
//            externalPositions.add(position);
//            new Employee(externalPositions,false,40);



    }
}
