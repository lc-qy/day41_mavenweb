package com.qfedu.first;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Demo2 {
    private static SqlSessionFactory factory = null;
    static {
        Reader resourceAsReader = null;
        try {
            resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(resourceAsReader);
    }

    public static void add2() {
        SqlSession session = factory.openSession();
        //执行插入操作
        Employee employee = new Employee();
        employee.setName("老邢");
        employee.setAge(33);
        employee.setSex("男");
        employee.setPhone("12321334");
        session.insert("empMapper.add2",employee);
        session.commit();
        session.close();
    }

    public static void main(String[] args) {
        add2();
    }
}
