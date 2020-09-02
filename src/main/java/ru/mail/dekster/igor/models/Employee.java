package ru.mail.dekster.igor.models;

import java.io.Serializable;

    public class Employee implements Serializable {
        private Integer id;
        private Department Department;
        private String name;
        private String surname;
        private String patronymic;
        private Integer salary;
        private Vacation vacation;
        private String profession;
        private Integer stage;
        private String role;

        public Employee() {
        }

        public Employee(Department department, String name,
                         String surname, String patronymic, Integer salary,
                         Vacation vacation, String profession,
                         Integer stage, String roles) {
            this.Department = department;
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            this.salary = salary;
            this.vacation = vacation;
            this.profession = profession;
            this.stage = stage;
            this.role = roles;
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Department getDepartment() {
            return Department;
        }

        public void setDepartment(Department department) {
            this.Department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public void setPatronymic(String patronymic) {
            this.patronymic = patronymic;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public Vacation getVacation() {
            return vacation;
        }

        public void setVacation(Vacation vacation) {
            this.vacation = vacation;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public Integer getStage() {
            return stage;
        }

        public void setStage(Integer stage) {
            this.stage = stage;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
}