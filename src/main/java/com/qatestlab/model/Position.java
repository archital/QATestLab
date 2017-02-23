package com.qatestlab.model;

import com.qatestlab.model.enums.IsSalaryPerHour;
import com.qatestlab.model.enums.PositionName;

/**
 * Created by APopichenko on 22.02.2017.
 */
public class Position {
 private IsSalaryPerHour isSalaryPerHour;
 private float salary;
 private PositionName positionName;

 public Position(IsSalaryPerHour isSalaryPerHour, float salary, PositionName positionName) {
  this.isSalaryPerHour = isSalaryPerHour;
  this.salary = salary;
  this.positionName = positionName;
 }

 public IsSalaryPerHour getIsSalaryPerHour() {
  return isSalaryPerHour;
 }

 public void setIsSalaryPerHour(IsSalaryPerHour isSalaryPerHour) {
  this.isSalaryPerHour = isSalaryPerHour;
 }

 public float getSalary() {
  return salary;
 }

 public void setSalary(float salary) {
  this.salary = salary;
 }

 public PositionName getPositionName() {
  return positionName;
 }

 public void setPositionName(PositionName positionName) {
  this.positionName = positionName;
 }

 public Position() {
 }


 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;

  Position position = (Position) o;

  if (Float.compare(position.salary, salary) != 0) return false;
  if (isSalaryPerHour != position.isSalaryPerHour) return false;
  return positionName == position.positionName;

 }

 @Override
 public int hashCode() {
  int result = isSalaryPerHour.hashCode();
  result = 31 * result + (salary != +0.0f ? Float.floatToIntBits(salary) : 0);
  result = 31 * result + positionName.hashCode();
  return result;
 }


 @Override
 public String toString() {
  return "Position{" +
          "isSalaryPerHour=" + isSalaryPerHour +
          ", salary=" + salary +
          ", positionName=" + positionName +
          '}';
 }
}
