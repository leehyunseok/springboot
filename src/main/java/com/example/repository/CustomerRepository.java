package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
//	List<Customer> findAllOrderByName();
	Page<Customer> findAllOrderByName(Pageable pageable);
}



// under 2.3
/*package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;

@Repository
@Transactional
public class CustomerRepository {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate ;
	SimpleJdbcInsert insert ;
	
	@PostConstruct
	public void init() {
		insert = new SimpleJdbcInsert((JdbcTemplate)jdbcTemplate.getJdbcOperations()).withTableName("customers").usingGeneratedKeyColumns("id");
	}
	
	 @PostConstruct
	    public void init() {
	        insert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations()) // (1)
	                .withTableName("customers") // (2)
	                .usingGeneratedKeyColumns("id"); // (3)
	    }
	
	
	private static final RowMapper<Customer> customerRowMapper = (rs , i ) -> {
		
		Integer id  = rs.getInt("id");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name") ;
		return new Customer(id,firstName,lastName) ;
		
	} ;
	
	private final ConcurrentMap<Integer, Customer> customerMap = new ConcurrentHashMap<>() ;
	
	public List<Customer> findAll() {
		List<Customer> customers = jdbcTemplate.query("SELECT id,first_name,last_name FROM customers ORDER BY id", customerRowMapper);
		return customers ;
	}
	
	public Customer findOne(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id) ;
		return jdbcTemplate.queryForObject("SELECT id, first_name, last_name FROM customers WHERE id=:id",param,customerRowMapper);
	}
	
	public Customer save(Customer customer) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
		if(customer.getId() == null ){

			Number key = insert.executeAndReturnKey(param);
			customer.setId(key.intValue());			
//			jdbcTemplate.update("INSERT INTO customers(first_name, last_name) values (:firstName, :lastName)", param) ;
			
		} else {
			jdbcTemplate.update("UPDATE customers SET fist_name=:firstName, last_name=:lastName WHERE id=:id", param);
		}
		return customer ;
	}
	
	public void delete(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id) ;
		jdbcTemplate.update("DELETE FROM customers WHERE id=:id", param) ;
	}
	
	public List<Customer> findAll() {
		return new ArrayList<Customer>(customerMap.values()) ;
	}
	
	public Customer findOne(Integer customerId) {
		return customerMap.get(customerId);
	}
	
	public Customer save(Customer customer) {
		return customerMap.put(customer.getId(),customer);
	}
	
	public void delete(Integer customerId){
		customerMap.remove(customerId) ;
	}

}
*/