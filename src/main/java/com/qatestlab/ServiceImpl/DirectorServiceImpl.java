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
    private Map<PositionName, String> tasks;
    private TasksForExternalEmployees tasksForExternalEmployees;
    private Set<Position> externalPositions;
    @Autowired
    private Position position;

    @Override
    public void grantTasksToEmployee(Set<Employee> employees, Map<PositionName, String> tasks) {
        this.tasks = tasks;

        for (Iterator i = employees.iterator(); i.hasNext(); ) {
         this.employee = (Employee) i.next();
         this.positions = employee.getPositionSet();


            for (Position position: positions) {
                //рандомно решаем 1 или 2 часа уйдет на выполнение задачи
                spendTime = new SecureRandom().nextInt((2 - 1) + 1)+1;

                if ((employee.getPositionSet().contains(position)) && position.getPositionName()==PositionName.Tester && (!employee.isBusy())) {
                   employee.setSpendTime(spendTime);
                    employee.addTask(tasks.get(PositionName.Tester));
                    tasks.remove(PositionName.Tester);
                }
                if ((employee.getPositionSet().contains(position)) && position.getPositionName()==PositionName.Programmer && (!employee.isBusy())) {
                    employee.setSpendTime(spendTime);
                    employee.addTask(tasks.get(PositionName.Programmer));
                    tasks.remove(PositionName.Programmer);
                }
                if ((employee.getPositionSet().contains(position)) && position.getPositionName()==PositionName.Designer && (!employee.isBusy())) {
                    employee.setSpendTime(spendTime);
                    employee.addTask(tasks.get(PositionName.Designer));
                    tasks.remove(PositionName.Designer);
                }
                if ((employee.getPositionSet().contains(position)) && position.getPositionName()==PositionName.Manager && (!employee.isBusy())) {
                    employee.setSpendTime(spendTime);
                    employee.addTask(tasks.get(PositionName.Manager));
                    tasks.remove(PositionName.Manager);
                }
                if ((employee.getPositionSet().contains(position)) && position.getPositionName()==PositionName.Accountment && (!employee.isBusy())) {
                    employee.setSpendTime(spendTime);
                    employee.addTask(tasks.get(PositionName.Accountment));
                    tasks.remove(PositionName.Accountment);
                }
            }
        }
        //Если еще есть задачи для сотрудников, но все работники заняты,
        //то нанимаем внешнего работника

        if (!tasks.isEmpty()){

            Iterator iterator = tasks.entrySet().iterator();
            while (iterator.hasNext()) {

                //рандомно решаем 1 или 2 часа уйдет на выполнение задачи
                spendTime = new SecureRandom().nextInt((2 - 1) + 1)+1;
                //Если нету нанятого работника на работу свободного

            }

            //рандомно решаем 1 или 2 часа уйдет на выполнение задачи
            spendTime = new SecureRandom().nextInt((2 - 1) + 1)+1;
            externalPositions = new HashSet<>();
          //  position.setPositionName(PositionName.ExternalEmployee);
            position.setSalary(400);
            position.setIsSalaryPerHour(IsSalaryPerHour.YES);
            externalPositions.add(position);
            new Employee(externalPositions,false,40);
        }
    }
}
