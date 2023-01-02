package com.example.Testcontainters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
    
  
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/")
    public List<Customer> customers() {
        List<Customer> customers = customerDao.findAll();
        customers.forEach(c -> logger.info("Found a customer: {}", c));
        return customers;
    }

}
