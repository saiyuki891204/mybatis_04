package com.cx.mybatis.dao.mapper;

import com.cx.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    public Employee getEmployeeById(Integer id);

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void deleteEmpById(Integer id);

    public Employee getEmployeeByIdAndLastname(@Param("id")Integer id,@Param("last_name")String lastName);

    public Employee getEmployeeByMap(Map map);

    public List<Employee> getEmpListByLastnameLike(String lastName);

    //返回一条记录的map key就是列名 值就是对应的值
    public Map<String,Object> getEmployeeByIdReturnMap(Integer id);

    //多条记录封装一个map Map<Integer,Employee> 键是这条记录的主键，值是javabean
    @MapKey("id")       //指定哪个属性作为map的key
    public Map<Integer,Employee> getEmpListByLastnameLikeReturnMap(String lastName);
}
