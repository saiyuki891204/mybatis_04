package com.cx.mybatis.dao.mapper;

import com.cx.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapperDynamicSQL {

   public List<Employee> getEmpsByConditionIf(Employee employee);
   public List<Employee> getEmpsByConditionTrim(Employee employee);
   public List<Employee> getEmpsByConditionChoose(Employee employee);
   public int updateEmp(Employee employee);


}
