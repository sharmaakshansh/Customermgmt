package com.cust.customerassesment.cstmrdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cust.customerassesment.cstmrentities.Admins;

@EnableJpaRepositories
public interface AdminsDao extends JpaRepository<Admins, Long> {

	Admins findByLoginId(String username);

	

	

	

	

}
