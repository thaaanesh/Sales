package com.task.Exampledemo.Service;

import com.task.Exampledemo.Model.Customer;
import com.task.Exampledemo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository theCustomerRepository;
    @Autowired

    public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
        this.theCustomerRepository = theCustomerRepository;
    }
    @Transactional
    @Override
    public Customer save(Customer theCustomer) {
        return theCustomerRepository.save(theCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return theCustomerRepository.findAll();
    }

    @Override
    public Customer findById(int cus_id) {
        Optional<Customer> result=theCustomerRepository.findById(cus_id);
        Customer theCustomer=null;
        if(result.isPresent())
        {
            theCustomer=result.get();
        }
        else{
            throw new RuntimeException("cus_id not found"+cus_id);
        }
        return theCustomer;
    }

    @Override
    public Customer update(int cus_id, Customer updateCustomer) {
        Customer existingCustomer=theCustomerRepository.findById(cus_id).orElse(null);
        if(existingCustomer!=null)
        {
            existingCustomer.setAddress(updateCustomer.getAddress());
            existingCustomer.setCus_name(updateCustomer.getCus_name());
            existingCustomer.setPhn_number(updateCustomer.getPhn_number());
            //existingCustomer.setCus_id(updateCustomer.getCus_id());
            return theCustomerRepository.save(existingCustomer);
        }
        return null;
    }
    @Transactional
    @Override
    public void  deleteById(int cus_id) {
         theCustomerRepository.deleteById(cus_id);
    }
}
