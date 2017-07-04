package com.deppon.bigdata.entity;

import java.util.Date;

/**
 * Project name data_provider
 * <p>
 * Package name com.deppon.bigdata.entity
 * <p>
 * Description:
 * <p>
 * Created by 326007
 * <p>
 * Created date 2017/6/20
 */
public class User {
    private int id;
    private String name;
    private Date birthDate;
    private double salary;

    public User() {
        super();
    }

    public User(int id, String name, Date birthDate, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate
                + ", salary=" + salary + "]";
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
