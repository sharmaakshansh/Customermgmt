package com.cust.customerassesment.cstmrentities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admins {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String designation;

	    private String loginId;

	    private String password;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * @param id
		 * @param designation
		 * @param loginId
		 * @param password
		 */
		public Admins( String designation, String loginId, String password) {
			
			this.designation = designation;
			this.loginId = loginId;
			this.password = password;
		}

		/**
		 * 
		 */
		public Admins() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
}
