package com.training.database.demodatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.database.demodatabase.Entity.Person;
import com.training.database.demodatabase.jdbc.PersonJdbcDao;


@SpringBootApplication
public class DemoDatabaseApplication implements CommandLineRunner {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
			
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users ->{}",dao.findAll() );
		//logger.info("user id 10001 ->{}",dao.findById(10001) );
		logger.info("user id 10001 ->{}",dao.deletById(10002) );
		logger.info("inserting 10004-> {}",dao.insert
				(new Person(10004, "rajesh", "chitradurga", new Date())));
		logger.info("updateing 10001-> {}",dao.upate
				(new Person(10001, "jeevan", "ajjampura", new Date())));

	}

}
