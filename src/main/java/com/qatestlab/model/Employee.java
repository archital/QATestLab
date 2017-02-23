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

    public Employee(Set<Position> positionSet, int hoursPerDay) {
        this.positionSet = positionSet;
        this.hoursPerMonth = hoursPerDay;
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
        return !(positionSet != null ? !positionSet.equals(employee.positionSet) : employee.positionSet != null);

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

    @Override
    public String toString() {
        return "Employee{" +
                "positionSet=" + positionSet +
                ", hoursPerDay=" + hoursPerMonth +
                '}';
    }
}
