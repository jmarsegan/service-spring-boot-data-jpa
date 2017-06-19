Launch :
 - cd service-spring-boot-data-jpa
 - mvn spring-boot:run
 
 Endpoints : 
  - GET http://localhost:8080/api/hello
  - GET http://localhost:8080/api/save => insert Customers in H2 database
  - GET http://localhost:8080/api/findAll => fetch all customers
  - GET http://localhost:8080/api/find/Bauer => fetch Bauer customer

 Swagger :
  - GET http://localhost:8080/system/
  
 Devtools :
  - live restart
  
 Unit Test :
  - WebEnvironment.RANDOM_PORT
  
 Jersey Config :
  - register(LoggingFeature.class)
