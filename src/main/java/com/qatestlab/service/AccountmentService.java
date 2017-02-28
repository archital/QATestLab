package com.qatestlab.service;



import com.qatestlab.model.Employee;
import com.qatestlab.model.ExternalEmployee;

import java.util.Set;

/**
 * Created by APopichenko on 23.02.2017.
 */
public interface AccountmentService {
    //В методе расчитывается и выплачуется зарплата всем внешним и внутренним сотрудникам за неделю
    public float calculateSalary (Set<Employee> employees, Set<ExternalEmployee> externalEmployees);
    //Метод возвращает суму к выплате за месяц
    public float getTotalMonthSalary ();
}
