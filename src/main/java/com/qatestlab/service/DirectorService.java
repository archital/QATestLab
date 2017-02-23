package com.qatestlab.service;

import com.qatestlab.model.Employee;
import com.qatestlab.model.Position;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by APopichenko on 22.02.2017.
 */
public interface DirectorService {
    public void grantTasksToEmployee(Employee employee, List<String> tasks); //назначить задачи на сотрудника
}
