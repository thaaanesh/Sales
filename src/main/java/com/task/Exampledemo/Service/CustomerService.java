package com.task.Exampledemo.Service;

import com.task.Exampledemo.Model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer theCustomer);

    List<Customer> findAll();

    Customer findById(int cus_id);

    Customer update(int cus_id,Customer updateCustomer);

    void deleteById(int cus_id);



}
