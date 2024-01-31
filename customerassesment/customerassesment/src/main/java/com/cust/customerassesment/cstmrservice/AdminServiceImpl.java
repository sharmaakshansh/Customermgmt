package com.cust.customerassesment.cstmrservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cust.customerassesment.cstmrdao.AdminsDao;
import com.cust.customerassesment.cstmrentities.Admins;

@Service
public class AdminServiceImpl implements AdminService {
	
	 private final AdminsDao adminsDao;
	    private final PasswordEncoder passwordEncoder;

	    @Autowired
	    public AdminServiceImpl(AdminsDao adminsDao, PasswordEncoder passwordEncoder) {
	        this.adminsDao = adminsDao;
	        this.passwordEncoder = passwordEncoder;
	    }

	    @Override
	    public Admins createAdmin(String designation, String loginId, String password) {
	        
	        // Encode the password before saving it
	        String encodedPassword = passwordEncoder.encode(password);

	        // Create a new Admin entity
	        Admins admin = new Admins(designation, loginId, encodedPassword);

	        // Save the admin to the database
	        return adminsDao.save(admin);
	    }

}
