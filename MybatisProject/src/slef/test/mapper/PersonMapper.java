package slef.test.mapper;

import java.util.List;

import slef.test.entity.Grade;
import slef.test.entity.Person;

public interface PersonMapper {
   Person queryPersonById(int id);
   List<Person> queryPersonByNameAndAge(Person person);
   int insertPerson(Person person);
   int deletePersonByName(String name );
   List<Person> queryAllPerson();
   Person queryPersonByIdWithConv(int id);
   int updataPerson(Person person);
   List<Person> queryPersonByIds(Grade grade);
   
   
}
