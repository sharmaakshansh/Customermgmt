package com.cust.customerassesment.cstmrservice;

import com.cust.customerassesment.cstmrentities.Admins;

public interface AdminService {

	Admins createAdmin(String designation, String loginId, String password);
}
