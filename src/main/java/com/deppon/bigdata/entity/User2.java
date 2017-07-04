package com.deppon.bigdata.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.Serializable;
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
@XStreamAlias("aliasUser")
public class User2 implements Serializable{

    @XStreamAlias("aliasid")
    private int id;

    @XStreamAlias("aliasname")
    private String name;

    @XStreamAlias("aliasbirthDate")
    @XStreamConverter(SimpleDateConverter.class)
    private Date birthDate;

    @XStreamAlias("aliassalary")
    private double salary;

    @XStreamOmitField
    private String other;//忽略

    public User2() {
        super();
    }

    public User2(int id, String name, Date birthDate, double salary) {
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
        return "User2 [id=" + id + ", name=" + name + ", birthDate=" + birthDate
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

}
