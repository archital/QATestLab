package com.qatestlab.ServiceImpl;

import com.qatestlab.model.Employee;
import com.qatestlab.model.ExternalEmployee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.IsSalaryPerHour;
import com.qatestlab.model.enums.PositionName;
import com.qatestlab.service.DirectorService;
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
    private ExternalEmployee externalEmployee;
    private Set<Position> positions;
    private Set<Position> positionsForExternalEmployee;
    private String employeeTask;
    private int spendTime;
    private Map<PositionName, String> tasks = null;
    private Set<Position> externalPositions = new HashSet<>();
    @Autowired
    private Position position;
    private int weekPerMonth;
    private Set<Employee> employees;
    private Set<ExternalEmployee> externalEmployees;


    @Override
    public void grantTasksToEmployee(Set<Employee> employees, Set<ExternalEmployee> externalEmployees, Map<PositionName, String> tasks, int weekPerMonth) {
        this.tasks = tasks;
        this.weekPerMonth = weekPerMonth;
        this.externalEmployees = externalEmployees;
        this.employees = employees;


            for (Iterator i = employees.iterator(); i.hasNext(); ) {
                this.employee = (Employee) i.next();
                //Если началась новая неделя, то обнуляем количество часов для работа и добавляем
                if (employee.getWeekPerMonth() != weekPerMonth) {
                    employee.setHoursPerWeekend(40);
                    employee.setIsBusy(false);

                }
            }

            for (Iterator i = externalEmployees.iterator(); i.hasNext(); ) {
                this.externalEmployee = (ExternalEmployee) i.next();
                //Если началась новая неделя, то обнуляем количество часов для работа и добавляем
                if (externalEmployee.getWeekPerMonth() != weekPerMonth) {
                    externalEmployee.setHoursPerWeekend(40);
                    externalEmployee.setIsBusy(false);
                    externalEmployee.setWeekPerMonth(weekPerMonth);

                }
            }

        //Проверяем есть ли свободный сотрудник для назначения на задачу и назначаем на него.

        checkIfEmployeeIsFree(employees, tasks, weekPerMonth);



        if (!tasks.isEmpty()) {

            grantTasksToExternalEmployee(externalEmployees, tasks, weekPerMonth);
        }
    }

    @Override
    public void grantTasksToExternalEmployee(Set<ExternalEmployee> externalEmployees, Map<PositionName, String> tasks, int weekPerMonth) {
        //Проверяем есть ли свободный внешний сотрудник для назначения на задачу и назначаем на него.
        checkIfExternalEmployeeIsFree(externalEmployees, tasks, weekPerMonth);

        if (!tasks.isEmpty()) {
            externalEmployees.add(createNewExternalEmployee(tasks, weekPerMonth));
            checkIfExternalEmployeeIsFree(externalEmployees,tasks,weekPerMonth);

        }


    }

    public Set<ExternalEmployee> getExternalEmployees() {
        return externalEmployees;
    }

    @Override
    public void checkIfEmployeeIsFree(Set<Employee> employees, Map<PositionName, String> tasks, int weekPerMonth) {

        for (Iterator i = employees.iterator(); i.hasNext(); ) {
            this.employee = (Employee) i.next();
            this.positions = employee.getPositionSet();

            for (Position position : positions) {
                //рандомно решаем 1 или 2 часа уйдет на выполнение задачи
                spendTime = new SecureRandom().nextInt((2 - 1) + 1) + 1;


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

        this.tasks = tasks;
    }

    @Override
    public void checkIfExternalEmployeeIsFree(Set<ExternalEmployee> externalEmployees, Map<PositionName, String> tasks, int weekPerMonth) {
        for (Iterator i = externalEmployees.iterator(); i.hasNext(); ) {
            this.externalEmployee = (ExternalEmployee) i.next();
            this.positions = externalEmployee.getPositionSet();


            for (Position position : positions) {
                //рандомно решаем 1 или 2 часа уйдет на выполнение задачи
                spendTime = new SecureRandom().nextInt((2 - 1) + 1) + 1;


                if (tasks.containsKey(position.getPositionName()) && position.getPositionName() == PositionName.Tester && (!externalEmployee.isBusy())) {
                    externalEmployee.setSpendTime(spendTime);
                    externalEmployee.setCurrentTask(tasks.get(PositionName.Tester));
                    externalEmployee.addTask(tasks.get(PositionName.Tester), weekPerMonth);
                    tasks.remove(PositionName.Tester);
                }
                if (tasks.containsKey(position.getPositionName()) && position.getPositionName() == PositionName.Programmer && (!externalEmployee.isBusy())) {
                    externalEmployee.setSpendTime(spendTime);
                    externalEmployee.setCurrentTask(tasks.get(PositionName.Programmer));
                    externalEmployee.addTask(tasks.get(PositionName.Programmer), weekPerMonth);
                    tasks.remove(PositionName.Programmer);
                }
                if (tasks.containsKey(position.getPositionName()) && position.getPositionName() == PositionName.Designer && (!externalEmployee.isBusy())) {
                    externalEmployee.setSpendTime(spendTime);
                    externalEmployee.setCurrentTask(tasks.get(PositionName.Designer));
                    externalEmployee.addTask(tasks.get(PositionName.Designer), weekPerMonth);
                    tasks.remove(PositionName.Designer);
                }
                if (tasks.containsKey(position.getPositionName()) && position.getPositionName() == PositionName.Manager && (!externalEmployee.isBusy())) {
                    externalEmployee.setSpendTime(spendTime);
                    externalEmployee.setCurrentTask(tasks.get(PositionName.Manager));
                    externalEmployee.addTask(tasks.get(PositionName.Manager), weekPerMonth);
                    tasks.remove(PositionName.Manager);
                }
                if (tasks.containsKey(position.getPositionName()) && position.getPositionName() == PositionName.Accountment && (!externalEmployee.isBusy())) {
                    externalEmployee.setSpendTime(spendTime);
                    externalEmployee.setCurrentTask(tasks.get(PositionName.Accountment));
                    externalEmployee.addTask(tasks.get(PositionName.Accountment), weekPerMonth);
                    tasks.remove(PositionName.Accountment);
                }
            }
        }

        this.tasks = tasks;
    }

    @Override
    public ExternalEmployee createNewExternalEmployee(Map<PositionName, String> tasks, int weekPerMonth) {
        externalPositions = new HashSet();

        Iterator entries = tasks.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            PositionName positionName = (PositionName) thisEntry.getKey();
            String task = (String) thisEntry.getValue();


            if (positionName == PositionName.Director) {
                externalPositions.add(new Position(IsSalaryPerHour.NO, 600, PositionName.Director));
            } else if (positionName == PositionName.Accountment)

            {
                externalPositions.add(new Position(IsSalaryPerHour.NO, 500, PositionName.Accountment));
            } else if (positionName == PositionName.Manager)

            {
                externalPositions.add(new Position(IsSalaryPerHour.NO, 300, PositionName.Manager));
            } else if (positionName == PositionName.Designer)

            {
                externalPositions.add(new Position(IsSalaryPerHour.YES, 20, PositionName.Designer));
            } else if (positionName == PositionName.Programmer)

            {
                externalPositions.add(new Position(IsSalaryPerHour.YES, 15, PositionName.Programmer));
            } else if (positionName == PositionName.Tester)

            {
                externalPositions.add(new Position(IsSalaryPerHour.YES, 5, PositionName.Tester));
            }


        }
        externalEmployee = new ExternalEmployee(externalPositions,false,40,getWeekPerMonth());
        return externalEmployee;
    }

    public int getWeekPerMonth() {
        return weekPerMonth;
    }
}
