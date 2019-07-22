package com.cx.mybatis.bean;

import java.util.List;

public class Dept {
    private int id;
    private String dept_name;
    private List<Employee> emps;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", dept_name='" + dept_name + '\'' +
                ", emps=" + emps +
                '}';
    }
}
