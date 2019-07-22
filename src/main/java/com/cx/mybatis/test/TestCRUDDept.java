package com.cx.mybatis.test;

import com.cx.mybatis.bean.Dept;
import com.cx.mybatis.bean.Employee;
import com.cx.mybatis.dao.mapper.DeptMapper;
import com.cx.mybatis.dao.mapper.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestCRUDDept {



    @Test
    public void getEmpByIdStep() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);

        try {
//            Dept dept = deptMapper.getDeptByIdPlus(1);
            Dept dept =deptMapper.getDeptByIdStep(1);

            System.out.println(dept.toString());
            List<Employee> emps = dept.getEmps();
           for (Employee employee : emps){
               System.out.println(employee.toString());
           }
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
