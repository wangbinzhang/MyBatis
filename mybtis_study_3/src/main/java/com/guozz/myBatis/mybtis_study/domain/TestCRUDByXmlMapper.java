package com.guozz.myBatis.mybtis_study.domain;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCRUDByXmlMapper {
	
	 static SqlSessionFactory sessionFactory;
	
	@BeforeClass
	public static  void beforeClass(){
		  //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	@Test
	public void testAddUser(){
		SqlSession sqlSession = sessionFactory.openSession();
		 /**
         * 映射sql的标识字符串，
         * com.guozz.myBatis.mybtis_study.mapper.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * addUser是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.guozz.myBatis.mybtis_study.mapper.userMapper.addUser";//映射sql的标识字符串
        User user = new User();
        user.setName("嘎嘎我爱你");
        user.setAge(20);
        int result = sqlSession.insert(statement, user);
        //手动提交事务
        sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(result);       
        
	}
	@Test
	public void testDeleteUser(){
		SqlSession sqlSession = sessionFactory.openSession();
		
		String statement = "com.guozz.myBatis.mybtis_study.mapper.userMapper.deleteUser";//映射sql的标识字符串
		int result = sqlSession.delete(statement, 6);
		 //手动提交事务
        sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(result);       
		
	}
	
	@Test
	public void testUpdateUser(){
		SqlSession sqlSession = sessionFactory.openSession();		
		String statement = "com.guozz.myBatis.mybtis_study.mapper.userMapper.updateUser";//映射sql的标识字符串
		User user = new User();
        user.setId(1);
        user.setName("孤傲苍狼2");
        //user.setAge(25);
		int result = sqlSession.update(statement, user);
		 //手动提交事务
        sqlSession.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(result);       
	}
	
	@Test
	public void testGetAllUser(){
		SqlSession sqlSession = sessionFactory.openSession();		
		String statement = "com.guozz.myBatis.mybtis_study.mapper.userMapper.getAllUsers";//映射sql的标识字符串
		List<User> lstUsers = sqlSession.selectList(statement);
		//手动提交事务
	    sqlSession.commit();
	    //使用SqlSession执行完SQL之后需要关闭SqlSession
	    sqlSession.close();
	    System.out.println(lstUsers.size());       
	}
	
}
