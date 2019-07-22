package com.cx.mybatis.test;

import com.cx.mybatis.bean.Employee;
import com.cx.mybatis.dao.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCRUD {

    @Test
    public void testGetEmpListByLastnameLike() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//            List<Employee> list = employeeMapper.getEmpListByLastnameLike("%e%");
//            for (Employee employee : list){
//                System.out.println(employee);
//            }

//            Map<String, Object> returnMap = employeeMapper.getEmployeeByIdReturnMap(1);
//            System.out.println("========="+returnMap.get("last_name"));

            Map<Integer, Employee> returnMap = employeeMapper.getEmpListByLastnameLikeReturnMap("%e%");
            System.out.println("========="+returnMap.size());
            Employee employee = returnMap.get(2);
            System.out.println(employee.getLast_name()+"**********");

            sqlSession.commit();
        }finally {
            sqlSession.close();

        }
    }

    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //测试添加
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null,"duoduo","1","uxiao@111.com");
            employeeMapper.addEmp(employee);
            System.out.println("获取到的主键值:"+employee.getId());

            //测试更新
//            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee employee = new Employee(2,"jerry","0","uxiao@222.com");
//            employeeMapper.updateEmp(employee);

            //测试查找
//            Employee employee = employeeMapper.getEmployeeById(2);
//            System.out.println(employee.toString());
            sqlSession.commit();
        }finally {
            sqlSession.close();

        }



    }

    @Test
    public void testGetEmployeeByIdAndLastname() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getEmployeeByIdAndLastname(1,"tom");
        System.out.println(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetEmployeeByMap() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Map map = new HashMap();
        map.put("id",1);
        map.put("lastName","tom");
        Employee employee = employeeMapper.getEmployeeByMap(map);
        System.out.println(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
//
//        try {
//            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee employee = mapper.getEmployeeById(1);
//
//            System.out.println(employee);
//        }finally {
//            sqlSession.close();
//        }
    }
}
