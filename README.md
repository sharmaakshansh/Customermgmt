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



![RegisterAdmin](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/093a5b83-17a8-402e-abb8-6e9858693a96)




2.) Login and get Jwt Token




         POST  ||  http://localhost:8081/auth/login
         Body  --> raw --> JSON

            {
             "loginId": "test@sunbasedata.com",
              "password": "Test@123"
                }

            Expected (format)O/P (x.y.z)  :
                           {
                               "jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHN1bmJhc2VkYXRhLmNvbSIsImlhdCI6MTcwNjY4NjU
                                            5MSwiZXhwIjoxNzA2NzA0NTkxfQ.eYlMWsiW7ZS5Kx00rYaGMPDVCGp5dmEgKbS7t2I
                                            dDyc29YHGtq_JWyAw7sPVuGL6pIzJc6Y4ZnBC6wJBZ72LuQ",
                               "username": "test@sunbasedata.com"
                           }
           

![generate jwt token](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/773ae17c-2373-4454-8523-5989b5521369)




#PostMan_Commands_After_authorization/accessing_token



![Noaccess to api if token not passed](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/70a40331-f206-49ba-8a85-f841e090c997)

![Using JWTbearer](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/97bb4406-1375-4cbc-aab8-d84821c6417c)

![using jwt bearer(2)](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/c7962e39-9deb-4c2a-b195-6a3b3df8883e)

 
 
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


               NOTE:- firstName and email cannot remain empty there is validation control over there .
                       So make sure while creating customer right variables are used for passing value.




![Post a customer](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/91e0be2b-cd17-4d6b-8d52-fdc8504170ce)



2.) // To get customers







                                   GET  || http://localhost:8081/api/customers?pageNumber=1&pageSize=10&sortBy=id&sortDir=asc

       Note:- pageNumber starts from 0.By this command pageNumber 1 will be displayed which has 10 elements and are sorted by id in ascending order.



![getcustomerswith pagination and sorting](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/34c04273-aa62-4dfa-aecc-6c626e22e889)





3.) // To get customer by id 







                   GET  ||     http://localhost:8080/api/customers/{id}

                   Example :-  http://localhost:8081/api/customers/7



![getcustomerbyId](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/2b85c0bd-e067-4cd2-8bb2-b9731a9f4dc4)







4.) // Search By firstName






                            GET     || http://localhost:8080/api/customers/searchByfirstname/{keyword}

                             example :- http://localhost:8080/api/customers/searchByfirstname/Ashu


![SearchByfirstName](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/c7d378e7-ba14-431b-82bc-f4092a050fff)




5.) // Search By Phone





                       GET     || http://localhost:8080/api/customers/searchByPhone/{keyword}

                       example :- http://localhost:8080/api/customers/searchByPhone/99393939

![SearchByPhone](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/9d906f12-b189-404b-8344-ef2353dc0852)




6.) // Search By Email


                               GET     || http://localhost:8080/api/customers/searchByEmail/{keyword}

                         Example :- http://localhost:8081/api/customers/searchByEmail/william.wilson@example.com


![SearchByEmail](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/ebb4260b-9612-40ff-8efb-ba921cdf5b1c)





7.) // Search by city






                            GET    ||  http://localhost:8080/api/customers/searchByCity/{keyword}

                            Example :- http://localhost:8081/api/customers/searchByCity/Hollywood



![SearchBy City](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/bcca0103-fd08-4cb5-82da-7e052c3d9054)





8.) // Update a customer with id 





                        PUT   || http://localhost:8081/api/customers/id

                        Example :- http://localhost:8081/api/customers/{8} 

![To update data of a customer](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/828bfabd-34ee-48f6-847d-1cf5e8d52d8a)







9.) // Delete a customer



                  Delete  ||  http://localhost:8081/api/customers/{id}

                  Example :-  http://localhost:8081/api/customers/9


![To delete a customer](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/302a72b9-f3d1-4b0c-ae82-35a5f98b4446)

#Local_Database

![database](https://github.com/sharmaakshansh/Customermgmt/assets/121374240/2749af4a-4dc4-4bb3-86c2-0966dca9b892)

