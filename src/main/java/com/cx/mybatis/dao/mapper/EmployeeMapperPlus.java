package com.cx.mybatis.dao.mapper;

import com.cx.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapperPlus {

    public Employee getEmpAndDept(Integer id);

    public Employee getEmpByIdStep(Integer id);

    public List<Employee> getEmpsByDeptid(Integer deptId);

    /**使用鉴别器
     * @param deptId
     * @return
     */
    public List<Employee> getEmpByDeptIdStep2(Integer deptId);
}
