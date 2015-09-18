package com.guozz.myBatis.mybtis_study.domain;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.guozz.myBatis.mybtis_study.mapper.UserMapperI;
import com.guozz.myBatis.mybtis_study.util.MyBatisUtil;

public class TestCRUDByAnnotationMapper {


	 static SqlSessionFactory sessionFactory;
		
	@BeforeClass
	public static  void beforeClass(){
		  //mybatis的配置文件
       String resource = "conf.xml";
       //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
       InputStream is = TestCRUDByAnnotationMapper.class.getClassLoader().getResourceAsStream(resource);
       //构建sqlSession的工厂
       sessionFactory = new SqlSessionFactoryBuilder().build(is);
       //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
       //Reader reader = Resources.getResourceAsReader(resource); 
       //构建sqlSession的工厂
       //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
    @Test
    public void testAdd(){
    	 SqlSession sqlSession = sessionFactory.openSession();
        //得到UserMapper接口的实现类对象，UserMapper接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        User user = new User();
        user.setName("用户xdp");
        user.setAge(20);
        int add = mapper.add(user);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        System.out.println(add);
    }
    
    @Test
    public void testUpdate(){
    	SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapper接口的实现类对象，UserMapper接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        User user = new User();
        user.setId(3);
        user.setName("孤傲苍狼_xdp");
        user.setAge(26);
        //执行修改操作
        int retResult = mapper.update(user);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        System.out.println(retResult);
    }
    
    @Test
    public void testDelete(){
    	SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapper接口的实现类对象，UserMapper接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //执行删除操作
        int retResult = mapper.deleteById(6);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        System.out.println(retResult);
    }
    
    @Test
    public void testGetUser(){
    	SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapper接口的实现类对象，UserMapper接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //执行查询操作，将查询结果自动封装成User返回
        User user = mapper.getById(8);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        System.out.println(user);
    }
    
    @Test
    public void testGetAll(){
    	SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapper接口的实现类对象，UserMapper接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<User> lstUsers = mapper.getAll();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        System.out.println(lstUsers);
    }
}