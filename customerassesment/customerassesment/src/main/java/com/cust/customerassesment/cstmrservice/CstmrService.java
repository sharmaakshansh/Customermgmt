package com.cust.customerassesment.cstmrservice;

import java.util.List;

import com.cust.customerassesment.cstmrpayload.CustomerDto;
import com.cust.customerassesment.cstmrpayload.CustomerResponse;


public interface CstmrService {
	
	CustomerResponse getAllCustomers(Integer pageN, Integer pageSize,String sortBy, String sortDir);

	CustomerDto getCustomerById(Long id);

    CustomerDto createCustomer(CustomerDto customer);

    CustomerDto updateCustomer(Long id, CustomerDto updatedCustomerDto);

    void deleteCustomer(Long id);
    
    List<CustomerDto> searchCustomersByfirstName(String keyword);
    
 // CustomerService.java
    List<CustomerDto> searchCustomersByEmail(String keyword);

 // CustomerService.java
    List<CustomerDto> searchCustomersByPhone(String keyword);

 // CustomerService.java
    List<CustomerDto> searchCustomersByCity(String keyword);

    
    
}
