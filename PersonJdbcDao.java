package com.training.database.demodatabase.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.database.demodatabase.Entity.Person;

@Repository
public class PersonJdbcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person;",
				new BeanPropertyRowMapper(Person.class));
	}
	
//	public Object findById(int id){
//		String str="select * from person where id=?";
//		return jdbcTemplate.queryForObject(str,new Object[] {id},
//				new BeanPropertyRowMapper(Person.class));
		
		public int deletById(int id){
			String str="delete from person where id=?";
			return jdbcTemplate.update(str,new Object[] {id});

}
		public int insert(Person person) {
			String str="insert into person (id,name,location,birth_Date)" + "values (?,?,?,?)" ;
			return jdbcTemplate.update(str,new Object[]
					{person.getId(),person.getName(),person.getLocation(),
							new Timestamp(person.getDate().getTime())});
			}
		
		public int upate(Person person) {
			String str="update person"+" set name = ?, location =?,birth_Date=? "+" where id=?";
			return jdbcTemplate.update(str,new Object[]
					{person.getName(),person.getLocation(),
							new Timestamp(person.getDate().getTime()),person.getId()});
			}
}	
