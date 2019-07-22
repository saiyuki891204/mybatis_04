package com.cx.mybatis.test;

import com.cx.mybatis.bean.Employee;
import com.cx.mybatis.dao.mapper.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestCRUDPlus {

    @Test
    public void testGetEmpByDeptIdStep2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapperPlus employeeMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);
        try {
            List<Employee> employeeList = employeeMapperPlus.getEmpByDeptIdStep2(1);
            for (Employee employee : employeeList){
                System.out.println(employee);
            }
            sqlSession.commit();
        }finally {
            sqlSession.close();

        }
    }

    @Test
    public void getEmpByIdStep() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapperPlus employeeMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);

        try {
            Employee employee = employeeMapperPlus.getEmpByIdStep(1);

            System.out.println(employee.toString());
            System.out.println(employee.getDept().toString());
            sqlSession.commit();
        }finally {
            sqlSession.close();

        }
    }

    @Test
    public void testgetEmpAndDept() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmployeeMapperPlus employeeMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);

        try {
            Employee employee = employeeMapperPlus.getEmpAndDept(1);

            System.out.println(employee.toString());
            System.out.println(employee.getDept().toString());
            sqlSession.commit();
        }finally {
            sqlSession.close();

        }
    }

    static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
}
