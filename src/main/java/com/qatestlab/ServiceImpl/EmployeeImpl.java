package com.qatestlab.ServiceImpl;

import com.qatestlab.exceptions.ExternalEmployeeException;
import com.qatestlab.exceptions.RequiredlEmployeesNotFoundException;
import com.qatestlab.model.Employee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.IsSalaryPerHour;
import com.qatestlab.model.enums.PositionName;
import com.qatestlab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.*;

/**
 * Created by APopichenko on 22.02.2017.
 */
@Service
public class EmployeeImpl implements EmployeeService {

    private Set<Employee> employeeList;
    private Set<Position> positionList;
    @Autowired
    private Employee employee;
    @Autowired
    private Position position;
    private int countOfRequiredAcountants;
    private int countOfRequiredDirectors;
    private int countOfRequiredManagers;

    public Set<Employee> findAllEmployees() throws RequiredlEmployeesNotFoundException {
        return checkRandomEmployeesList(employeeList);
    }

//Метод создает случайное количество сотрудников от 1 до 100
    public void createEmployees(int randomCountOfEmployees, int hoursPerMonth) {

        employeeList = new HashSet();
        for (int i = 1; i <= randomCountOfEmployees; i++) {

            try {
                positionList = setRandomPosition();
            } catch (ExternalEmployeeException e) {
                e.printStackTrace();
            }
            employee = new Employee(positionList,false,hoursPerMonth); //создаем пользователя и задаем ему список должностей
            employeeList.add(employee); //добавляем сотрудника и его должности в список список
        }
    }

    //Метод создания набора позиций
    public Set<Position> setRandomPosition() throws ExternalEmployeeException {
        Set<Position>  list = new HashSet();
        int randomPositionNumber; //рамдомный порядок позиции от 1 до 6
        int randomPositionsCount = new SecureRandom().nextInt((6 - 1) + 1)+1; //рандомное количество ролей для одного сотрудника


        for (int i = 0; i <= randomPositionsCount; i++) {
            //Инициализируем позиции в соответствии с @randomPositionNumber
            randomPositionNumber = new SecureRandom().nextInt(6);
            if(randomPositionNumber == PositionName.Director.ordinal()){

                list.add(new Position(IsSalaryPerHour.NO,500,PositionName.Director));
            } else if (randomPositionNumber == PositionName.Accountment.ordinal())
            {
                list.add(new Position(IsSalaryPerHour.NO,100,PositionName.Accountment));
            } else if (randomPositionNumber == PositionName.Manager.ordinal())
            {
                list.add(new Position(IsSalaryPerHour.NO,200,PositionName.Manager));
            } else if (randomPositionNumber == PositionName.Designer.ordinal())
            {
                list.add(new Position(IsSalaryPerHour.YES,250,PositionName.Designer));
            } else if (randomPositionNumber == PositionName.Programmer.ordinal())
            {
                list.add(new Position(IsSalaryPerHour.YES,150,PositionName.Programmer));
            } else if (randomPositionNumber == PositionName.Tester.ordinal())
            {
                list.add(new Position(IsSalaryPerHour.YES,50,PositionName.Tester));
            } else
            {

                    throw new ExternalEmployeeException("External employee could not been created as Internal");
            }
            }

        return list;

    }
    //Метод проверки сгенерированного случайного списка сотрудников на наявность в нем Director, Accountment, Manager
    public Set<Employee> checkRandomEmployeesList(Set<Employee> employees) throws RequiredlEmployeesNotFoundException {

      Position acountant = new Position(IsSalaryPerHour.NO,100,PositionName.Accountment);
        Position director = new Position(IsSalaryPerHour.NO,500,PositionName.Director);
        Position manager = new Position(IsSalaryPerHour.NO,200,PositionName.Manager);

        countOfRequiredAcountants =0;
        countOfRequiredDirectors=0;
        countOfRequiredManagers=0;

        for (Iterator i = employees.iterator(); i.hasNext(); ) {

            employee = (Employee) i.next();
            if (employee.getPositionSet().contains(acountant))

            {
                countOfRequiredAcountants++;
            }
            else
            if (employee.getPositionSet().contains(director))

            {
                countOfRequiredDirectors++;
            }
            else
            if (employee.getPositionSet().contains(manager))

            {
                countOfRequiredManagers++;
            }
        }

        //проверяем какой именно должности не хватает и можем ли мы её добавить

        if(countOfRequiredAcountants == 0 && employees.size() <=100){
            Set<Position> positionsList = new HashSet();
            positionsList.add(acountant);
        employees.add(new Employee(positionsList, false, 40));
            System.out.println("add one more required Accountant");
        } else
        if(countOfRequiredDirectors == 0 && employees.size() <=100){
            Set<Position> positionsList = new HashSet();
            positionsList.add(acountant);
            employees.add(new Employee(positionsList, false, 40));
            System.out.println("add one more required Director");
        } else
        if(countOfRequiredManagers == 0 && employees.size() <=100){
            Set<Position> positionsList = new HashSet();
            positionsList.add(acountant);
            employees.add(new Employee(positionsList, false, 40));
            System.out.println("add one more required Manager");
        } else if ((countOfRequiredDirectors == 0 || countOfRequiredDirectors == 0 || countOfRequiredManagers == 0) && employees.size() >100){
            throw new RequiredlEmployeesNotFoundException(" Required employees are not found and coud not been set to list");
        }




        return employees;
    }

    //Метод выполняет одну задачу
    public void taskExecution(String task) {

    }
}
