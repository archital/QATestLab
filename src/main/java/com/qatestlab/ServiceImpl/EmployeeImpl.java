package com.qatestlab.ServiceImpl;

import com.qatestlab.exceptions.ExternalEmployeeException;
import com.qatestlab.model.Employee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.IsSalaryPerHour;
import com.qatestlab.model.enums.PositionName;
import com.qatestlab.service.EmployeeService;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by APopichenko on 22.02.2017.
 */
public class EmployeeImpl implements EmployeeService {

    private Set<Employee> employeeList;
    private Set<Position> positionList;
    private Employee employee;


    public Set<Employee> findAllEmployees() {
        return employeeList;
    }


    public Set<Employee> createEmployees(int randomCountOfEmployees, int hoursPerDay) {

        employeeList = new HashSet();
        for (int i = 1; i <= randomCountOfEmployees; i++) {

            try {
                positionList = setRandomPosition();
            } catch (ExternalEmployeeException e) {
                e.printStackTrace();
            }
            employee = new Employee(positionList,hoursPerDay); //создаем пользователя и задаем ему список должностей
            employeeList.add(employee); //добавляем сотрудника и его должности в список список
        }
        return employeeList;
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

        // добавляем хотяб по одной должности директора, бухгалтера, или менеджера в список, если таких нету
        if ((!list.contains(new Position(IsSalaryPerHour.YES,50,PositionName.Director)))
        || (!list.contains(new Position(IsSalaryPerHour.YES,50,PositionName.Accountment)))
        || (!list.contains(new Position(IsSalaryPerHour.YES,50,PositionName.Manager))))
        {
            new Position(IsSalaryPerHour.YES,50,PositionName.Director);
            new Position(IsSalaryPerHour.YES,50,PositionName.Accountment);
            new Position(IsSalaryPerHour.YES,50,PositionName.Manager);
        }
        return list;

    }

  //Метод выполняет одну задачу задачу
    public void taskExecution(String task) {

    }
}
