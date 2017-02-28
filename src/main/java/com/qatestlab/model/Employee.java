package com.qatestlab.model;

import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by APopichenko on 22.02.2017.
 */
@Component
public class Employee {

    private Set<Position> positionSet; //Список позиций
    private int hoursPerWeekend = 40; // 40 рабочих часов в неделю
    private int hoursPerWeekendWasWorked = 0; //фактическое (затрэканное) время работы сотрудника
    private float totalWeekSalaryPerEmployee; //зарплата за неделю
    private String currentTask; //текущая задача
    private boolean isBusy = false; // флаг занятости сотрудника
    private int spendTime; //сколько сотрудник потратит времени (в часах) на выполнение задачи
    private int weekPerMonth = 1; // какая по счёту неделя месяца (от 1 до 4)

    public int getHoursPerWeekendWasWorked() {
        return hoursPerWeekendWasWorked;
    }

    public void setHoursPerWeekendWasWorked(int hoursPerWeekendWasWorked) {
        this.hoursPerWeekendWasWorked = hoursPerWeekendWasWorked;
    }


    public Employee(Set<Position> positionSet, boolean isBusy, int hoursPerMonth, int weekPerMonth) {
        this.positionSet = positionSet;
        this.isBusy = isBusy;
        this.hoursPerWeekend = hoursPerMonth;
        this.weekPerMonth = weekPerMonth;
    }

    public int getWeekPerMonth() {
        return weekPerMonth;
    }

    public void setWeekPerMonth(int weekPerMonth) {
        this.weekPerMonth = weekPerMonth;
    }

    public Employee(Set<Position> positionSet, boolean isBusy, int hoursPerMonth) {
        this.positionSet = positionSet;
        this.isBusy = isBusy;
        this.hoursPerWeekend = hoursPerMonth;
    }

    public Set<Position> getPositionSet() {
        return positionSet;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (isBusy != employee.isBusy) return false;
        if (!positionSet.equals(employee.positionSet)) return false;
        return true;

    }


    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    @Override
    public int hashCode() {
        int result = positionSet != null ? positionSet.hashCode() : 0;
        return result;
    }

    public void setSpendTime(int spendTime) {
        this.spendTime = spendTime;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public Employee() {
    }

    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }

    @Override
    public String toString() {
        return
                "employee,s positions : " + positionSet;
    }

    //Метод выполняет процесс взятия задачи в работу сотрудником
    public void addTask(String task, int weekPerMonth){
        if (weekPerMonth > getWeekPerMonth())
        {
            setHoursPerWeekend(40);
            setHoursPerWeekendWasWorked(0);
        }

        if(getHoursPerWeekend()<=0 && weekPerMonth == getWeekPerMonth()) {
            setIsBusy(true);
            setCurrentTask(task);
        }
        else if (hoursPerWeekend > 0)
        {
            setIsBusy(false);
            setCurrentTask(task);
            setWeekPerMonth(weekPerMonth);
            setHoursPerWeekend(getHoursPerWeekend() - spendTime);
            setHoursPerWeekendWasWorked(getHoursPerWeekendWasWorked()+spendTime);
        }



    }

    public float getTotalWeekSalaryPerEmployee() {
        return totalWeekSalaryPerEmployee;
    }

    public void setTotalWeekSalaryPerEmployee(float totalWeekSalaryPerEmployee) {
        this.totalWeekSalaryPerEmployee = totalWeekSalaryPerEmployee;
    }

    public int getHoursPerWeekend() {
        return hoursPerWeekend;
    }

    public void setHoursPerWeekend(int hoursPerWeekend) {
        this.hoursPerWeekend = hoursPerWeekend;
    }


}
