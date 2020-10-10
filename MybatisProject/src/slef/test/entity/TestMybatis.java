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
	{	//����mybatis�����ļ�
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//��ȡmapper
		Person person = personMapper.queryPersonById(2);//ִ��mapper�ķ���		
	    System.out.println(person);
	    sqlSession.close();
	}

	
	public static void queryPersonByIds () throws IOException
	{	//����mybatis�����ļ�
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//��ȡmapper
		Grade grade =new Grade();
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(8);
		grade.setIds(ids);
		List<Person> person = personMapper.queryPersonByIds(grade);//ִ��mapper�ķ���
		 System.out.println(person);
/*		List<Person> person1 = personMapper.queryPersonByIds(grade);//ִ��mapper�ķ���
	    System.out.println(person1);*/
	    sqlSession.close();
	}
	
	
	public static void deletePersonByName  () throws IOException
	{	//����mybatis�����ļ�
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//��ȡmapper
		int count = personMapper.deletePersonByName("���");//ִ��mapper�ķ���		
		   System.out.println("�ɹ�ɾ��"+ count +"����Ϣ��");
		   sqlSession.commit();
	    sqlSession.close();
	}

	
	public static void queryPersonByNameAndAge () throws IOException
	{	//����mybatis�����ļ�
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//��ȡmapper
		Person  person = new Person("���",21,0);
		person.setAge(21);
		person.setName("���Ʒ�");
		List<Person> persons = personMapper.queryPersonByNameAndAge(person);//ִ��mapper�ķ���		
	    System.out.println(persons);
	    sqlSession.close();
	}

	
	
	//ʹ��ת����
	public static void queryPersonByIdWithConv () throws IOException
	{	//����mybatis�����ļ�
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//��ȡmapper
		Person person = personMapper.queryPersonByIdWithConv(1);//ִ��mapper�ķ���
		
	    System.out.println(person);
	    sqlSession.close();
	}

	
	
	public static void insertPerson () throws IOException
	{	//����mybatis�����ļ�
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//��ȡmapper
		Person  person = new Person("���",21,0);
		int result = personMapper.insertPerson(person);//ִ��mapper�ķ���
	    System.out.println("�ɹ�����"+ result +"����Ϣ��");
	    sqlSession.commit();
	    sqlSession.close();
	  
	}
	
	
	
	public static void updataPerson () throws IOException
	{	//����mybatis�����ļ�
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//��ȡmapper
		Person  person = new Person(2,"���Ʒ�",21,1);
		int result = personMapper.updataPerson(person);//ִ��mapper�ķ���
	    System.out.println("�ɹ��޸�"+ result +"����Ϣ��");
	    sqlSession.commit();
	    sqlSession.close();
	}
	
	public static void queryAllPerson () throws IOException
	{	//����mybatis�����ļ�
		Reader  reader = Resources.getResourceAsReader("config.xml");
		//SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		session  -- connection
		SqlSession  sqlSession= sqlSessionFactory.openSession();
		
		PersonMapper  personMapper = sqlSession.getMapper(PersonMapper.class);//��ȡmapper
		List<Person> persons = personMapper.queryAllPerson();//ִ��mapper�ķ���


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
