package com.qatestlab.model;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by APopichenko on 22.02.2017.
 */
@Component
public class Employee {

    private Set<Position> positionSet;
    private int hoursPerWeekend = 40;
    private int hoursPerWeekendWasWorked = 0;

    public int getHoursPerWeekendWasWorked() {
        return hoursPerWeekendWasWorked;
    }

    public void setHoursPerWeekendWasWorked(int hoursPerWeekendWasWorked) {
        this.hoursPerWeekendWasWorked = hoursPerWeekendWasWorked;
    }

    private String currentTask;
    private boolean isBusy = false;
    private int spendTime;
    private Lock lock = new ReentrantLock();
    private int weekPerMonth = 1;

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

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
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


    public String getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    @Override
    public int hashCode() {
        int result = positionSet != null ? positionSet.hashCode() : 0;
        return result;
    }

    public int getSpendTime() {
        return spendTime;
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
        return "Employee{" +
                "positionSet=" + positionSet +
                ", hoursPerWeekend=" + hoursPerWeekend +
                ", hoursPerWeekendWasWorked=" + hoursPerWeekendWasWorked +
                ", currentTask='" + currentTask + '\'' +
                ", isBusy=" + isBusy +
                ", spendTime=" + spendTime +
                ", weekPerMonth=" + weekPerMonth +
                '}';
    }

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

    public int getHoursPerWeekend() {
        return hoursPerWeekend;
    }

    public void setHoursPerWeekend(int hoursPerWeekend) {
        this.hoursPerWeekend = hoursPerWeekend;
    }


}
