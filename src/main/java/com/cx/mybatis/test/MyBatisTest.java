package com.cx.mybatis.test;

import com.cx.mybatis.bean.Employee;
import com.cx.mybatis.dao.mapper.EmployeeMapper;
import com.cx.mybatis.dao.mapper.EmployeeMapperAnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MyBatisTest {

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee employee = sqlSession.selectOne("selectEmp",1);

        sqlSession.close();
        System.out.println(employee.toString());
    }



    @Test
    public void testAnotation() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapperAnotation employeeMapperAnotation = sqlSession.getMapper(EmployeeMapperAnotation.class);
            Employee employee = employeeMapperAnotation.getEmployeeById(1);
            System.out.println(employee);
        }finally {
            sqlSession.close();
        }





    }
}
