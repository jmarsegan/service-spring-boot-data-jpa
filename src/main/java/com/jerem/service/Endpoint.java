package com.jerem.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.bred.common.soa.auth.ServiceContext;

@Component
public class Endpoint implements BSCarLoanSubscription {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private Service service;

    @Autowired
    private CustomerRepository repository;

    @GET
    @Path("/hello")
    public String message() throws Exception {
        return "Hello " + this.service.message();
    }

    @Override
    public Boolean activateCarLoan(ServiceContext serviceContext, Integer workcaseId) {
        this.service.message();
        return null;
    }

    @Override
    public Boolean lockTask(ServiceContext serviceContext, com.jerem.service.WorkcaseContext workcaseContext) {
        this.service.message();
        return null;
    }

    @Override
    public Boolean save() {
        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
        return true;
    }

    @Override
    public Boolean findAll() {
        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Customer customer : repository.findAll()) {
            log.info(customer.toString());
        }
        log.info("");
        return true;
    }

    @Override
    public Boolean find(String name) {
        // fetch customers by last name
        log.info("Customer found with findByLastName " + name);
        log.info("--------------------------------------------");
        for (Customer bauer : repository.findByLastName(name)) {
            log.info(bauer.toString());
        }
        log.info("");
        return true;
    }

}
