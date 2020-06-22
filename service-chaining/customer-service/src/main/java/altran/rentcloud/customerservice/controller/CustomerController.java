package altran.rentcloud.customerservice.controller;

import altran.rentcloud.customerservice.service.CustomerService;
import altran.rentcloud.model.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Author:Vivek Kumar
 * Date:21-06-2020
 * Link: http://localhost:9091/services/customers
 */
@RestController
@RequestMapping("/services/customers")
public class CustomerController {

    //Debugger
    public static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        log.info("Method call---->save");
        return customerService.save(customer);
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable int id) {
        log.info("request came on "+LocalDateTime.now() + "  ++++++++++++++++++++++");
        return customerService.findById(id);
    }

    @GetMapping(value = "/list")
    public List<Customer> getAllCustomers() {
        log.info("Method call---->getAllCustomer");
        return customerService.findAll();
    }




}
