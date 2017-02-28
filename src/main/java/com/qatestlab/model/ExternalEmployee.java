package com.qatestlab.model;

import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by Artur Popichenko on 26.02.17.
 */
@Component
public class ExternalEmployee extends Employee {



    @Override
    public String toString() {
        return "External " + super.toString();
    }

    public ExternalEmployee(Set<Position> positionSet, boolean isBusy, int hoursPerMonth, int weekPerMonth) {
        super(positionSet, isBusy, hoursPerMonth,weekPerMonth);
    }

    public ExternalEmployee() {
    }
}
