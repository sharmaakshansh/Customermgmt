# Customermgmt

PostMan command for Authorization
 
1.) Create a admin with designation

POST || http://localhost:8081/auth/create

Body --> raw --> JSON

{
  "designation": "Some Designation",
  "loginId": "test@sunbasedata.com",
  "password": "Test@123"
}





2.) Login and get Jwt Token

POST  ||  http://localhost:8081/auth/login

Body  --> raw --> JSON

{
 "loginId": "test@sunbasedata.com",
  "password": "Test@123"
}


Expected O/P   :
                 {
    "jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHN1bmJhc2VkYXRhLmNvbSIsImlhdCI6MTcwNjY4NjU5MSwiZXhwIjoxNzA2NzA0NTkxfQ.eYlMWsiW7ZS5Kx00rYaGMPDVCGp5dmEgKbS7t2IdDyc29YHGtq_JWyAw7sPVuGL6pIzJc6Y4ZnBC6wJBZ72LuQ",
    "username": "test@sunbasedata.com"
}





#PostMan_Commands_After_authorization/accessing_token



1.)  // To create a customer

POST   ||  http://localhost:8081/api/customers

Body --> raw --> JSON

{
"firstName": "John",
"lastName": "Doe",
"street": "Elvnu Street",
"address": "H no 2 ",
"city": "Delhi",
"state": "Delhi",
"email": "sam@gmail.com",
"phone": "12345678"
}


NOTE:- firstName and email cannot remain empty there is validation control over there . So make sure while creating customer right variables are used for passing value.






2.) // To get customers



GET  || http://localhost:8081/api/customers?pageNumber=1&pageSize=10&sortBy=id&sortDir=asc

Note:- pageNumber starts from 0.By this command pageNumber 1 will be displayed which has 10 elements and are sorted by id in ascending order.




3.) // To get customer by id 



GET  ||     http://localhost:8080/api/customers/{id}

Example :-  http://localhost:8081/api/customers/7





4.) // Search By firstName


GET     || http://localhost:8080/api/customers/searchByfirstname/{keyword}

example :- http://localhost:8080/api/customers/searchByfirstname/Ashu





5.) // Search By Phone


GET     || http://localhost:8080/api/customers/searchByPhone/{keyword}

example :- http://localhost:8080/api/customers/searchByPhone/99393939





6.) // Search By Email


GET     || http://localhost:8080/api/customers/searchByEmail/{keyword}

Example :- http://localhost:8081/api/customers/searchByEmail/william.wilson@example.com




7.) // Search by city

GET    ||  http://localhost:8080/api/customers/searchByCity/{keyword}

Example :- http://localhost:8081/api/customers/searchByCity/Hollywood




8.) // Update a customer with id 

PUT   || http://localhost:8081/api/customers/id

Example :- http://localhost:8081/api/customers/{8} 





9.) // Delete a customer

Delete  ||  http://localhost:8081/api/customers/{id}

Example :-  http://localhost:8081/api/customers/9



