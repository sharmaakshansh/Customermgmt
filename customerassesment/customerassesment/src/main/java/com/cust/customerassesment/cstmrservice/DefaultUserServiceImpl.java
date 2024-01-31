package com.cust.customerassesment.cstmrservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cust.customerassesment.cstmrentities.Admins;

import java.util.ArrayList;
import com.cust.customerassesment.cstmrdao.AdminsDao;


@Service
public class DefaultUserServiceImpl implements DefaultUserService {

	@Autowired
	AdminsDao adminRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		
		
		 Admins admin = adminRepo.findByLoginId(username);
	     return new org.springframework.security.core.userdetails.User(admin.getLoginId(), admin.getPassword(), new ArrayList<>());
		
	}

}
