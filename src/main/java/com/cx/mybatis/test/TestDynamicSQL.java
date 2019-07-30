package com.cx.mybatis.test;

import com.cx.mybatis.bean.Employee;
import com.cx.mybatis.dao.mapper.EmployeeMapperDynamicSQL;
import com.cx.mybatis.dao.mapper.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDynamicSQL {

    @Test
    public void testGetEmpsByConditionIf() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperDynamicSQL mapperDynamicSQL = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
        try {
            Employee conditionEmp = new Employee(2,"jerry",null,"@163.com");

//            List<Employee> employeeList = mapperDynamicSQL.getEmpsByConditionIf(conditionEmp);
//            List<Employee> employeeList = mapperDynamicSQL.getEmpsByConditionTrim(conditionEmp);
//            List<Employee> employeeList = mapperDynamicSQL.getEmpsByConditionChoose(conditionEmp);
           int r = mapperDynamicSQL.updateEmp(conditionEmp);
            System.out.println(r);
//            for (Employee employee : employeeList){
//                System.out.println(employee);
//            }
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
//

    static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
}
