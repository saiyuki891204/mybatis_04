package com.cx.mybatis.bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("employee")
public class Employee {

    private Integer id;
    private String last_name;
    private Dept dept;

    public Employee(Integer id, String last_name, String gender, String email) {
        this.id = id;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
    }

    private String gender;
    private String email;



    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
