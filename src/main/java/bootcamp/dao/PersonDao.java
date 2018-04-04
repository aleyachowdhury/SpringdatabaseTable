package bootcamp.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import bootcamp.model.Person;
@Component

public class PersonDao {

 @Autowired

 private JdbcTemplate jdbcTemplate;

 


 public Person getPersonById(int personid) {
	
	final String SQL = "SELECT personid, lastname, firstname, address, city FROM public.aleya where personid ="+personid;
	List<Person> p = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Person.class));
	return p.get(0);
 }
 
 public List<Person> createPersonById() {
		
		final String SQL = "insert into Aleya values(16, 'Somy', 'Ragen', '1043 Main', 'Atlanta')";
		List<Person> p = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Person.class));
		return p;
	 }

 public List<Person> getPerson() {
	 final String SQL = "SELECT * from public.aleya";
     List<Person> p = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Person.class));
     return p;
 
}

 public  List<Person> updatePersonbyId() {
	 final String SQL="UPDATE public.aleya set lastname='Update' where personid=3";
	 List<Person> p = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Person.class));
		return p;
 }
 
 public List<Person> deletePersonbyId(int personid) {
	 final String SQL="DELETE from public.aleya where personid="+personid;
	 List<Person> p = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Person.class));
		return p;
 }
 

}
	
	

