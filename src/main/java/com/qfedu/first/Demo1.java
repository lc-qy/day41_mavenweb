package com.qfedu.first;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Demo1 {
    public static void main(String[] args) {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
            //2.创建sqlsessionFactory对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsReader);
            //3.创建sqlsession对象
            SqlSession session = factory.openSession();
            //4.执行插入操作 命名空间+id 找到要执行的sql语句
            session.insert("empMapper.add");
            //5.提交   如果不写这个插入不成功
            session.commit();
            //6.关闭
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
