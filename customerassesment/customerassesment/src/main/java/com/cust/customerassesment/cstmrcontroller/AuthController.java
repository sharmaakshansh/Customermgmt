package com.cust.customerassesment.cstmrcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.cust.customerassesment.cstmrentities.Admins;

import com.cust.customerassesment.cstmrentities.JwtResponse;
import com.cust.customerassesment.cstmrservice.AdminService;
import com.cust.customerassesment.cstmrservice.DefaultUserService;
import com.cust.customerassesment.security.JwtHelper;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private DefaultUserService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private final AdminService adminService;

    @Autowired
    public AuthController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<Admins> createAdmin(@RequestBody Admins admin) {
        Admins createdAdmin = adminService.createAdmin(admin.getDesignation(), admin.getLoginId(), admin.getPassword());

        if (createdAdmin != null) {
            return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody Admins request) {

        this.doAuthenticate(request.getLoginId(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLoginId());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String login_id, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(login_id, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
