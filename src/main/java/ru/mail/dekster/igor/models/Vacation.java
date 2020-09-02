package ru.mail.dekster.igor.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Vacation implements Serializable {
    private int id;
    private LocalDate vacation;
    private LocalDate newVacation;
    private String resolution;
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int idVacation) {
        this.id = idVacation;
    }

    public LocalDate getVacation() {
        return vacation;
    }

    public void setVacation(LocalDate vacation) {
        this.vacation = vacation;
    }

    public LocalDate getNewVacation() {
        return newVacation;
    }

    public void setNewVacation(LocalDate newVacation) {
        this.newVacation = newVacation;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}