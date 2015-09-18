package com.guozz.myBatis.mybtis_study;



import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.guozz.myBatis.mybtis_study.domain.Classes;
import com.guozz.myBatis.mybtis_study.util.MyBatisUtil;

public class TestMapper {	
	 @Test
	    public void testGetClass(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * 映射sql的标识字符串，
	         * com.guozz.myBatis.mybtis_study.mapper.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
	         * getClass是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "com.guozz.myBatis.mybtis_study.mapper.classMapper.getClass";//映射sql的标识字符串
	        //执行查询操作，将查询结果自动封装成Classes对象返回
	        Classes clazz = sqlSession.selectOne(statement,1);//查询class表中id为1的记录
	        //使用SqlSession执行完SQL之后需要关闭SqlSession
	        sqlSession.close();
	        System.out.println(clazz);//打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
	    }
	    
	    @Test
	    public void testGetClass2(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * 映射sql的标识字符串，
	         * com.guozz.myBatis.mybtis_study.mapper.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
	         * getClass2是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "com.guozz.myBatis.mybtis_study.mapper.classMapper.getClass2";//映射sql的标识字符串
	        //执行查询操作，将查询结果自动封装成Classes对象返回
	        Classes clazz = sqlSession.selectOne(statement,1);//查询class表中id为1的记录
	        //使用SqlSession执行完SQL之后需要关闭SqlSession
	        sqlSession.close();
	        System.out.println(clazz);//打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
	    }
	    
	    @Test
	    public void testGetClass3(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * 映射sql的标识字符串，
	         * me.gacl.mapping.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
	         * getClass3是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "com.guozz.myBatis.mybtis_study.mapper.classMapper.getClass3";//映射sql的标识字符串
	        //执行查询操作，将查询结果自动封装成Classes对象返回
	        Classes clazz = sqlSession.selectOne(statement,1);//查询class表中id为1的记录
	        //使用SqlSession执行完SQL之后需要关闭SqlSession
	        sqlSession.close();
	        //打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1], students=[Student [id=1, name=student_A], Student [id=2, name=student_B], Student [id=3, name=student_C]]]
	        System.out.println(clazz);
	    }
	    
	    @Test
	    public void testGetClass4(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * 映射sql的标识字符串，
	         * me.gacl.mapping.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
	         * getClass4是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "com.guozz.myBatis.mybtis_study.mapper.classMapper.getClass4";//映射sql的标识字符串
	        //执行查询操作，将查询结果自动封装成Classes对象返回
	        Classes clazz = sqlSession.selectOne(statement,1);//查询class表中id为1的记录
	        //使用SqlSession执行完SQL之后需要关闭SqlSession
	        sqlSession.close();
	        //打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1], students=[Student [id=1, name=student_A], Student [id=2, name=student_B], Student [id=3, name=student_C]]]
	        System.out.println(clazz);
	    }
	    
	    
	    @Test
	    public void testGetUserCount(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * 映射sql的标识字符串，
	         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
	         * getUserCount是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "com.guozz.myBatis.mybtis_study.mapper.userMapper.getUserCount";//映射sql的标识字符串
	        Map<String, Integer> parameterMap = new HashMap<String, Integer>();
	        parameterMap.put("sexid", 0);
	        parameterMap.put("usercount", -1);
	        sqlSession.selectOne(statement, parameterMap);
	        Integer result = parameterMap.get("usercount");
	        System.out.println(result);
	        sqlSession.close();
	    }
	    
	    
}