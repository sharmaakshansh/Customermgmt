package com.cust.customerassesment.cstmrservice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cust.customerassesment.cstmrdao.CstmrDao;
import com.cust.customerassesment.cstmrentities.Customer;
import com.cust.customerassesment.cstmrpayload.CustomerDto;
import com.cust.customerassesment.cstmrpayload.CustomerResponse;

@Service
public class CstmrServiceImpl implements CstmrService {

	@Autowired 
	private final CstmrDao cstmrDao;
	
	@Autowired
	private ModelMapper modelMapper;

	    @Autowired
	    public CstmrServiceImpl(CstmrDao cstmrDao) {
	        this.cstmrDao = cstmrDao;
	    }

	    @Override
	    public CustomerResponse getAllCustomers(Integer pageNumber, Integer pageSize , String sortBy, String sortDir) {
	        Sort sort = null;
	    	if(sortDir.equalsIgnoreCase("asc"))
	        {
	        	sort=Sort.by(sortBy).ascending();
	        }
	    	else
	    	{
	    		sort=Sort.by(sortBy).descending();
	    	}
	        Pageable p = PageRequest.of(pageNumber, pageSize,sort );
	        Page<Customer> pagecustomers = this.cstmrDao.findAll(p);
	        List<Customer> allcustomers =pagecustomers.getContent();
	        List<CustomerDto> cstmrdtos = allcustomers.stream()
	                .map(customer -> this.modelMapper.map(customer, CustomerDto.class))
	                .collect(Collectors.toList());
	        
	        CustomerResponse cstmrResponse = new CustomerResponse();
	        cstmrResponse.setContent(cstmrdtos);
	        cstmrResponse.setPageNumber(pagecustomers.getNumber());
	        cstmrResponse.setPageSize(pagecustomers.getSize());
	        cstmrResponse.setTotalElements(pagecustomers.getTotalElements());
	        cstmrResponse.setTotalPages(pagecustomers.getTotalPages());
	        cstmrResponse.setLastPage(pagecustomers.isLast());
	        
	        		
	        return cstmrResponse;
	    }


	    @Override
	    public CustomerDto getCustomerById(Long id) {
	        Optional<Customer> optionalCustomer = cstmrDao.findById(id);
	        return optionalCustomer.map(this::customerTodto).orElse(null);
	    }

	    @Override
	    public CustomerDto createCustomer(CustomerDto customerdto) {
	        Customer cstmr = this.dtoToCustomer(customerdto);
	    	Customer savedCstmr = this.cstmrDao.save(cstmr);
	        return this.customerTodto(savedCstmr);
	    }

	    @Override
	    public CustomerDto updateCustomer(Long id, CustomerDto updatedCustomerDto) {
	        if (!cstmrDao.existsById(id)) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id " + id);
	        }

	        Customer updatedCustomer = dtoToCustomer(updatedCustomerDto);
	        updatedCustomer.setId(id);

	        Customer savedCustomer = cstmrDao.save(updatedCustomer);
	        return customerTodto(savedCustomer);
	    }


	    @Override
	    public void deleteCustomer(Long id) {
	        cstmrDao.deleteById(id);
	    }
	    
	    public Customer dtoToCustomer(CustomerDto cstmrdto)
	    {
	    	Customer cstmr = this.modelMapper.map(cstmrdto, Customer.class);
	    	return cstmr;
	    	
	    }
	    public CustomerDto customerTodto(Customer cstmr)
	    {
	    	CustomerDto cstmrdto = this.modelMapper.map(cstmr, CustomerDto.class);
	    	return cstmrdto;
	    }

		@Override
		public List<CustomerDto> searchCustomersByfirstName(String keyword) {
			// TODO Auto-generated method stub
			List<Customer> cstmr =this.cstmrDao.findByfirstNameContaining(keyword);
			    return cstmr.stream()
			    		.map((customer)->modelMapper.map(customer,CustomerDto.class ))
			    		.collect(Collectors.toList());
			
		}
		
		
		// CstmrServiceImpl.java
		@Override
		public List<CustomerDto> searchCustomersByCity(String keyword) {
		    List<Customer> customers = cstmrDao.findByCityContaining(keyword);
		    return customers.stream()
		        .map(customer -> modelMapper.map(customer, CustomerDto.class))
		        .collect(Collectors.toList());
		}

		// CstmrServiceImpl.java
		@Override
		public List<CustomerDto> searchCustomersByPhone(String keyword) {
		    List<Customer> customers = cstmrDao.findByPhoneContaining(keyword);
		    return customers.stream()
		        .map(customer -> modelMapper.map(customer, CustomerDto.class))
		        .collect(Collectors.toList());
		}

		// CstmrServiceImpl.java
		@Override
		public List<CustomerDto> searchCustomersByEmail(String keyword) {
		    List<Customer> customers = cstmrDao.findByEmailContaining(keyword);
		    return customers.stream()
		        .map(customer -> modelMapper.map(customer, CustomerDto.class))
		        .collect(Collectors.toList());
		}

	    
	    
}
