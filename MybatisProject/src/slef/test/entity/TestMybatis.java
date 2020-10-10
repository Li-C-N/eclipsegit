package slef.test.entity;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import slef.test.mapper.PersonMapper;

public class TestMybatis {
	public static void queryPersonById () throws IOException
	{	//加载mybatis配置文件
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//读取mapper
		Person person = personMapper.queryPersonById(2);//执行mapper的方法		
	    System.out.println(person);
	    sqlSession.close();
	}

	
	public static void queryPersonByIds () throws IOException
	{	//加载mybatis配置文件
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//读取mapper
		Grade grade =new Grade();
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(8);
		grade.setIds(ids);
		List<Person> person = personMapper.queryPersonByIds(grade);//执行mapper的方法
		 System.out.println(person);
/*		List<Person> person1 = personMapper.queryPersonByIds(grade);//执行mapper的方法
	    System.out.println(person1);*/
	    sqlSession.close();
	}
	
	
	public static void deletePersonByName  () throws IOException
	{	//加载mybatis配置文件
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//读取mapper
		int count = personMapper.deletePersonByName("李建东");//执行mapper的方法		
		   System.out.println("成功删除"+ count +"行信息！");
		   sqlSession.commit();
	    sqlSession.close();
	}

	
	public static void queryPersonByNameAndAge () throws IOException
	{	//加载mybatis配置文件
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//读取mapper
		Person  person = new Person("李建东",21,0);
		person.setAge(21);
		person.setName("段云锋");
		List<Person> persons = personMapper.queryPersonByNameAndAge(person);//执行mapper的方法		
	    System.out.println(persons);
	    sqlSession.close();
	}

	
	
	//使用转换器
	public static void queryPersonByIdWithConv () throws IOException
	{	//加载mybatis配置文件
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//读取mapper
		Person person = personMapper.queryPersonByIdWithConv(1);//执行mapper的方法
		
	    System.out.println(person);
	    sqlSession.close();
	}

	
	
	public static void insertPerson () throws IOException
	{	//加载mybatis配置文件
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//读取mapper
		Person  person = new Person("李建东",21,0);
		int result = personMapper.insertPerson(person);//执行mapper的方法
	    System.out.println("成功插入"+ result +"行信息！");
	    sqlSession.commit();
	    sqlSession.close();
	  
	}
	
	
	
	public static void updataPerson () throws IOException
	{	//加载mybatis配置文件
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//读取mapper
		Person  person = new Person(2,"段云锋",21,1);
		int result = personMapper.updataPerson(person);//执行mapper的方法
	    System.out.println("成功修改"+ result +"行信息！");
	    sqlSession.commit();
	    sqlSession.close();
	}
	
	public static void queryAllPerson () throws IOException
	{	//加载mybatis配置文件
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//读取mapper
		List<Person> persons = personMapper.queryAllPerson();//执行mapper的方法


	    System.out.println(persons);
	 
	  //  System.out.println(person);
	    sqlSession.close();
	}
	
public static void main(String[] args) throws IOException {
    
	//queryPersonById();
//insertPerson();
	//queryAllPerson();
	//queryPersonByIdWithConv();
	//queryPersonByNameAndAge();
	//deletePersonByName();
	//updataPerson();
	queryPersonByIds();
	}

}
