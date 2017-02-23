package com.qatestlab.model;

import java.util.List;
import java.util.Set;

/**
 * Created by APopichenko on 22.02.2017.
 */
public class Employee {

    private Set<Position> positionSet;
    private int hoursPerMonth;
    private List<String> tasks;
    private String currentTask;
    private boolean isBusy = false;

    public Employee(Set<Position> positionSet, boolean isBusy, int hoursPerMonth) {
        this.positionSet = positionSet;
        this.isBusy = isBusy;
        this.hoursPerMonth = hoursPerMonth;
    }

    public Set<Position> getPositionSet() {
        return positionSet;
    }

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
    }

    public int getHoursPerDay() {
        return hoursPerMonth;
    }

    public void setHoursPerDay(int hoursPerDay) {
        this.hoursPerMonth = hoursPerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (hoursPerMonth != employee.hoursPerMonth) return false;
        if (isBusy != employee.isBusy) return false;
        if (!positionSet.equals(employee.positionSet)) return false;
        return true;

    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
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
        result = 31 * result + hoursPerMonth;
        return result;
    }

    public int getHoursPerMonth() {
        return hoursPerMonth;
    }

    public void setHoursPerMonth(int hoursPerMonth) {
        this.hoursPerMonth = hoursPerMonth;
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
                ", hoursPerMonth=" + hoursPerMonth +
                ", tasks=" + tasks +
                ", currentTask='" + currentTask + '\'' +
                ", isBusy=" + isBusy +
                '}';
    }
}
