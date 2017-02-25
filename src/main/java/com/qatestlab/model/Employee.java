package com.qatestlab.model;

import java.security.SecureRandom;
import java.util.List;
import java.util.Set;

/**
 * Created by APopichenko on 22.02.2017.
 */
public class Employee {

    private Set<Position> positionSet;
    private int hoursPerWeekend = 40;
    private String currentTask;
    private boolean isBusy = false;
    private int spendTime;

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

    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "positionSet=" + positionSet +
                ", currentTask='" + currentTask + '\'' +
                ", isBusy=" + isBusy +
                '}';
    }

    public void addTask(String task){
        if(hoursPerWeekend<=0) {
            setIsBusy(true);
        }

        if(getCurrentTask() == null &&isBusy() == false){
            setCurrentTask(task);
        }

        hoursPerWeekend = getHoursPerWeekend()- spendTime;

    }

    public int getHoursPerWeekend() {
        return hoursPerWeekend;
    }

    public void setHoursPerWeekend(int hoursPerWeekend) {
        this.hoursPerWeekend = hoursPerWeekend;
    }


}
