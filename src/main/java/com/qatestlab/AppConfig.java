package com.qatestlab;

import com.qatestlab.ServiceImpl.AccountmentServiceImpl;
import com.qatestlab.ServiceImpl.DirectorServiceImpl;
import com.qatestlab.ServiceImpl.EmployeeImpl;
import com.qatestlab.model.Employee;
import com.qatestlab.model.ExternalEmployee;
import com.qatestlab.model.Position;
import com.qatestlab.model.enums.PositionName;
import com.qatestlab.service.AccountmentService;
import com.qatestlab.service.DirectorService;
import com.qatestlab.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Map;
import java.util.Set;

/**
 * Created by Artur Popichenko on 25.02.17.
 */
@Configuration
public class AppConfig  {
    @Bean
    public Employee employee() {
        Employee employee = new Employee();
        return employee;
    }

    @Bean
    public ExternalEmployee externalEmployee() {
        ExternalEmployee externalEmployee = new ExternalEmployee();
        return externalEmployee;
    }

    @Bean
    public Position position() {
        Position position = new Position();
        return position;
    }
    @Bean
    public WorkEmulation workEmulation() {
        WorkEmulation workEmulation = new WorkEmulation();
        return workEmulation;
    }

    @Bean
    public DirectorService directorService() {
        DirectorService directorService = new DirectorServiceImpl();
        return directorService;
    }

    @Bean
    public EmployeeService employeeService() {
        EmployeeService employeeService = new EmployeeImpl();
        return employeeService;
    }

    @Bean
    public AccountmentService accountmentService() {
        AccountmentService accountmentService = new AccountmentServiceImpl();
        return accountmentService;
    }

}
