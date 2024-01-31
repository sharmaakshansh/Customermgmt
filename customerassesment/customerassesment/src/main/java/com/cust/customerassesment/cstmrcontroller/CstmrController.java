package com.cust.customerassesment.cstmrcontroller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cust.customerassesment.cstmrpayload.CustomerDto;
import com.cust.customerassesment.cstmrpayload.CustomerResponse;
import com.cust.customerassesment.cstmrservice.CstmrService;

@RestController
@RequestMapping("/api/customers")
public class CstmrController {

	
	 private final CstmrService cstmrService;

	    @Autowired
	    public CstmrController(CstmrService cstmrService) {
	        this.cstmrService = cstmrService;
	    }

	    @GetMapping
	    public ResponseEntity<CustomerResponse> getAllCustomers(
	    		@RequestParam(value = "pageNumber",defaultValue ="0",required = false) Integer pageN,
	    		@RequestParam(value = "pageSize",defaultValue ="5",required = false) Integer pageSize,
	    		@RequestParam(value = "sortBy", defaultValue = "id", required = false ) String sortBy,
	    		@RequestParam(value = "sortDir", defaultValue = "asc",required = false) String sortDir
	    		) {
	        CustomerResponse cstmrResponse = this.cstmrService.getAllCustomers(pageN,pageSize,sortBy,sortDir);
	        return new ResponseEntity<CustomerResponse>(cstmrResponse , HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
	        CustomerDto customer = cstmrService.getCustomerById(id);
	        if (customer != null) {
	            return new ResponseEntity<>(customer, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerdto) {
	        CustomerDto createdCustomer = cstmrService.createCustomer(customerdto);
	        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto updatedCustomer) {
	        CustomerDto updated = cstmrService.updateCustomer(id, updatedCustomer);
	        if (updated != null) {
	            return new ResponseEntity<>(updated, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
	        cstmrService.deleteCustomer(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    //search
	    @GetMapping("/searchByfirstName/{keywords}")
	    public ResponseEntity<List<CustomerDto>> searchCustomerByfirstName(
	    		@PathVariable("keywords")String keywords){
	    	List<CustomerDto> result =  this.cstmrService.searchCustomersByfirstName(keywords);
	    	return new ResponseEntity<List<CustomerDto>>(result, HttpStatus.OK);
	    }
	    
	 // CstmrController.java
	    @GetMapping("/searchByEmail/{keyword}")
	    public ResponseEntity<List<CustomerDto>> searchCustomerByEmail(
	        @PathVariable("keyword") String keyword) {
	        List<CustomerDto> result = cstmrService.searchCustomersByEmail(keyword);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }

	 // CstmrController.java
	    @GetMapping("/searchByPhone/{keyword}")
	    public ResponseEntity<List<CustomerDto>> searchCustomerByPhone(
	        @PathVariable("keyword") String keyword) {
	        List<CustomerDto> result = cstmrService.searchCustomersByPhone(keyword);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }

	 // CstmrController.java
	    @GetMapping("/searchByCity/{keyword}")
	    public ResponseEntity<List<CustomerDto>> searchCustomerByCity(
	        @PathVariable("keyword") String keyword) {
	        List<CustomerDto> result = cstmrService.searchCustomersByCity(keyword);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }

	
}
