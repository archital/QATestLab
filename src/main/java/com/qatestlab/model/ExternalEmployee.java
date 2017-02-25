package com.qatestlab.model;

import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by Artur Popichenko on 26.02.17.
 */
@Component
public class ExternalEmployee extends Employee {

    private int MaxHoursAvailable = 40;
    private int hoursUsed = 0;

    public ExternalEmployee(Set<Position> positionSet, boolean isBusy, int hoursPerMonth) {
        super(positionSet, isBusy, hoursPerMonth);
    }


    public ExternalEmployee() {
    }


    @Override
    public void addTask(String task) {
        if(getHoursUsed()== getMaxHoursAvailable()) {
            setIsBusy(true);
        }

        if(getCurrentTask() == null &&isBusy() == false){
            setCurrentTask(task);
        }

        setHoursUsed(getHoursUsed() + getSpendTime());
    }


    public int getMaxHoursAvailable() {
        return MaxHoursAvailable;
    }

    public void setMaxHoursAvailable(int maxHoursAvailable) {
        MaxHoursAvailable = maxHoursAvailable;
    }

    public int getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(int hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

}
