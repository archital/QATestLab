package com.qatestlab.ServiceImpl;

import com.qatestlab.model.Employee;
import com.qatestlab.model.ExternalEmployee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.IsSalaryPerHour;
import com.qatestlab.service.AccountmentService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by APopichenko on 23.02.2017.
 */
@Service
public class AccountmentServiceImpl implements AccountmentService {
    private float totalWeekSarary;
    private float totalMonthSarary;
    private float totalWeekSararyPerEmployee;
    private Employee employee;
    private ExternalEmployee externalEmployee;
    private Set<Position> positions;

    @Override
    public float calculateSalary(Set<Employee> employees, Set<ExternalEmployee> externalEmployees) {
        this.totalWeekSarary = 0;

        //подсчитывем суму денег к оплате внутренним сотрудникам
        for (Iterator i = employees.iterator(); i.hasNext(); ) {
            this.employee = (Employee) i.next();
            this.positions = employee.getPositionSet();
            this.totalWeekSararyPerEmployee = 0;
            employee.setTotalWeekSalaryPerEmployee(0);

            for (Position position : positions) {
                if (position.getIsSalaryPerHour() == IsSalaryPerHour.NO) {
                    totalWeekSararyPerEmployee = totalWeekSararyPerEmployee + position.getSalary();
                } else {
                    totalWeekSararyPerEmployee = totalWeekSararyPerEmployee + employee.getHoursPerWeekendWasWorked()*position.getSalary();
                }
            }
            //записываем зарплату сотруднику
               employee.setTotalWeekSalaryPerEmployee(totalWeekSararyPerEmployee);
            //добавляем зарплату сотрудника к общей недельной зарплате
            totalWeekSarary = totalWeekSarary + totalWeekSararyPerEmployee;
        }


        //подсчитывем суму денег к оплате внешним сотрудникам
        for (Iterator i = externalEmployees.iterator(); i.hasNext(); ) {
            this.externalEmployee = (ExternalEmployee) i.next();
            this.positions = externalEmployee.getPositionSet();
            this.totalWeekSararyPerEmployee = 0;
            externalEmployee.setTotalWeekSalaryPerEmployee(0);

            for (Position position : positions) {
                if (position.getIsSalaryPerHour() == IsSalaryPerHour.NO) {
                    totalWeekSararyPerEmployee = totalWeekSararyPerEmployee + position.getSalary();
                } else {
                    totalWeekSararyPerEmployee = totalWeekSararyPerEmployee + externalEmployee.getHoursPerWeekendWasWorked()*position.getSalary();
                }
            }

            //записываем зарплату внешнему сотруднику
            externalEmployee.setTotalWeekSalaryPerEmployee(totalWeekSararyPerEmployee);
            //добавляем зарплату сотрудника к общей недельной зарплате
            totalWeekSarary = totalWeekSarary + totalWeekSararyPerEmployee;
        }

        setTotalMonthSarary(getTotalMonthSalary()+totalWeekSarary);
        return totalWeekSarary;
    }

    @Override
    public float getTotalMonthSalary() {
        return totalMonthSarary;
    }

    public void setTotalMonthSarary(float totalMonthSarary) {
        this.totalMonthSarary = totalMonthSarary;
    }
}
