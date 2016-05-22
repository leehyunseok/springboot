package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.Frontend;
import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;

import ch.qos.logback.core.net.SyslogOutputStream;

@EnableAutoConfiguration
//@Import (AppConfig.class)
@ComponentScan
//public class App implements CommandLineRunner {
public class App {

	
//	NamedParameterJdbcTemplate jdbcTemplate ;
	
//	@Autowired
//	CustomerRepository customerRepository ;

	/*
	public void run(String...strings) throws Exception {
		
		Customer created = customerRepository.save(new Customer(null,"Hideoshi","Dekisugi"));
		
		System.out.println(created + " is Created ");
		
//		customerRepository.findAll().forEach(System.out::println);
		customerRepository.findAll().forEach(System.out::println);
	
		
		Pageable pageable = new PageRequest(0,2) ;
//		Page<Customer> page = customerRepository.findAllOrderByName(pageable) ;
		Page<Customer> page = customerRepository.findAll(pageable) ;

		
		System.out.println(page.getSize());
		System.out.println(page.getNumber());
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		
		page.getContent().forEach(System.out::println);
		
		
	  
//		Page<Customer> page = customerRepository.findAll(pageable) ;
		
		
		
//		String sql = "Select :a + :b" ;
//		String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id" ;
//		SqlParameterSource param = new MapSqlParameterSource().addValue("id", 1);
		
		Customer result = jdbcTemplate.queryForObject(sql, param, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name")) ;
			}
			
		}) ;
		
//		Customer result = jdbcTemplate.queryForObject(sql, param, (rs,rowNum) -> new Customer(rs.getInt("id"), rs.getString("first_name"),rs.getString("last_name"))) ;
		
//		System.out.println("REsult => " + result);
	}
	*/
	
/*	@Autowired
	CustomerService customerService ;
	
	
	public void run(String...strings) throws Exception {
		customerService.save(new Customer(1,"shellsn","shellsnValue")) ;
		customerService.save(new Customer(2,"shellsn2","shellsnValue")) ;
		customerService.save(new Customer(3,"shellsn3","shellsnValue")) ;
		
		customerService.findAll().forEach(System.out::println);
	}
*/	
	/*
	@Autowired
	ArgumentResolver argumentResolver ;
	
	@Autowired
	Calculator calculator ;
	
	public void run (String... strings) throws Exception{
		
		System.out.println("Enter 2 number");
		Argument argument = argumentResolver.resolve(System.in) ;
		int result = calculator.calc(argument.getA(), argument.getB()) ;
		System.out.println("reuslt => " + result);
		
	}
	*/
	
	public static void main(String[] args) {
	
		SpringApplication.run(App.class, args) ;
		
		/*try( ConfigurableApplicationContext context  = SpringApplication.run(App.class, args) ) {
			
			Scanner scanner = new Scanner(System.in) ;
			System.out.println("enter2 number");
			int a = scanner.nextInt() ;
			int b = scanner.nextInt() ;
			
			System.out.println(a);
			System.out.println(b);
			
			
			ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
			Argument argument = argumentResolver.resolve(System.in) ;
			
			Calculator calculator = context.getBean(Calculator.class) ;
			
			System.out.println(calculator.calc(argument.getA(), argument.getB()));
			
			Frontend frontend = context.getBean(Frontend.class) ;
			
			frontend.run();
		}*/
	}

}
