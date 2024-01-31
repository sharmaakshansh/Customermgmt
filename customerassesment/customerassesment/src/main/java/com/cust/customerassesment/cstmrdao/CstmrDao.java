package com.cust.customerassesment.cstmrdao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cust.customerassesment.cstmrentities.Customer;

public interface CstmrDao extends JpaRepository<Customer, Long> {

	List<Customer> findByfirstNameContaining(String firstName);
	
	// CstmrDao.java
	List<Customer> findByEmailContaining(String email);

	// CstmrDao.java
	List<Customer> findByPhoneContaining(String phone);

	// CstmrDao.java
	List<Customer> findByCityContaining(String city);

}
