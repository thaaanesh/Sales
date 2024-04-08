package com.task.Exampledemo.Controller;

import com.task.Exampledemo.Model.Customer;
import com.task.Exampledemo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerService theCustomerService;
    @Autowired

    public CustomerController(CustomerService theCustomerService) {
        this.theCustomerService = theCustomerService;
    }
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer theCustomer)
    {
        Customer customer=theCustomerService.save(theCustomer);

        return customer;
    }
    @GetMapping("/customers")
    public List<Customer> findAll()
    {
        return theCustomerService.findAll();
    }
    @GetMapping("/customers/{cus_id}")
    public Customer findById(@PathVariable int cus_id)
    {
        Customer cus=theCustomerService.findById(cus_id);
        if(cus==null)
        {
            throw new RuntimeException("cus_id not found"+cus_id);
        }
        return cus;
    }
    @PutMapping ("/customers/{cus_id}")
    public Customer updateCustomer(@PathVariable int cus_id , @RequestBody Customer updateCustomer)
    {
        return theCustomerService.update(cus_id, updateCustomer);
    }
    @DeleteMapping("/customers/{cus_id}")
    public void deleteById(@PathVariable("cus_id") int cus_id)
    {
        theCustomerService.deleteById(cus_id);
    }
}
