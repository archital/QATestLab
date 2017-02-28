package com.qatestlab;

import com.qatestlab.model.Employee;
import com.qatestlab.model.ExternalEmployee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Artur Popichenko on 28.02.17.
 */

public class ReportGenerator {

    private Employee employee;
    private ExternalEmployee externalEmployee;
    private StringBuilder stringBuilder;
    private int j;

    //Метод возвращает строку с информацией за неделю

    public String writeWeekReportToFile(Set<Employee> employees, Set<ExternalEmployee> externalEmployees, int weekPerMonth) {
        j=0;
        stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append("Week # " +weekPerMonth);
        stringBuilder.append('\n');
        stringBuilder.append("=====================================================");
        stringBuilder.append('\n');
        //записываем информацию по начислениям зарплаты сотрудникам в конце недели
        for (Iterator i = employees.iterator(); i.hasNext(); ) {
            this.employee = (Employee) i.next();
            stringBuilder.append("Employee # "+(j+1));
            stringBuilder.append('\n');
            stringBuilder.append(employee.toString())
                    .append('\n')
                    .append(" Actual tracked time (hours in week) for execution tasks = "+employee.getHoursPerWeekendWasWorked())
                    .append('\n')
                    .append(" Salary earned per week = ");
            stringBuilder.append(employee.getTotalWeekSalaryPerEmployee());
            stringBuilder.append('\n');
            stringBuilder.append("------------------------------------------------");
            stringBuilder.append('\n');
            //После записи в репорт фактических отработаных часов в неделю, обнуляем счетчик этих часов.
            employee.setHoursPerWeekendWasWorked(0);
            j++;
        }
        j=0;
        //записываем информацию по начислениям зарплаты сотрудникам в конце недели
        for (Iterator i = externalEmployees.iterator(); i.hasNext(); ) {
            this.externalEmployee = (ExternalEmployee) i.next();
            stringBuilder.append('\n');
            stringBuilder.append("External employee # "+(j+1));
            stringBuilder.append('\n');
            stringBuilder.append(externalEmployee.toString())
                    .append('\n')
                    .append(" Actual tracked time (hours in week) for execution tasks = "+externalEmployee.getHoursPerWeekendWasWorked())
                    .append('\n')
                    .append(" Salary earned per week = ");
            stringBuilder.append(externalEmployee.getTotalWeekSalaryPerEmployee());
            stringBuilder.append('\n');
            stringBuilder.append("------------------------------------------------");
            stringBuilder.append('\n');
            //После записи в репорт фактических отработаных часов в неделю, обнуляем счетчик.
            externalEmployee.setHoursPerWeekendWasWorked(0);
            j++;
        }
        j=0;
        return stringBuilder.toString();
    }

    //Метод возвращает строку с информацией за месяц
    public String writeMonthReportToFile(float totalSalaryPerMonth, int internalEmployeeCount, int externalEmployeeCount) {
        stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append("============TOTAL PER MONTH==================");
        stringBuilder.append('\n');
        stringBuilder.append("Total salary per company = ").append(totalSalaryPerMonth);
        stringBuilder.append('\n');
        stringBuilder.append("Total count of internal employees = ").append(internalEmployeeCount);
        stringBuilder.append('\n');
        stringBuilder.append("Total count of external employees = ").append(externalEmployeeCount);
        return stringBuilder.toString();
    }

    //Метод записывает отчет в файл QATestLab Report.txt
    public void writeReportToFile(String data) throws IOException {

        File file = new File("D:\\QATestLab Report.txt");
        file.createNewFile();
        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
                br.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
