package com.qatestlab.model;

import java.util.Set;

/**
 * Created by APopichenko on 24.02.2017.
 */
public class ExternalEmployee extends Employee {

    private String currentTask;
    private int spendTime;

    public ExternalEmployee(Set<Position> positionSet, boolean isBusy, int hoursPerMonth) {
        super(positionSet, isBusy, hoursPerMonth);
    }

    @Override
    public void addTask(String task) {
        super.addTask(task);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int getHoursPerWeekend() {
        return super.getHoursPerWeekend();
    }

    @Override
    public void setHoursPerWeekend(int hoursPerWeekend) {
        super.setHoursPerWeekend(hoursPerWeekend);
    }
}
