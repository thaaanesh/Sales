package com.task.Exampledemo.Service;

import com.task.Exampledemo.Model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product theProduct);
    List<Product> findAll();

    Product findById(int prod_id);

    Product updateProduct(int prod_id,Product updateProduct);

    void deleteById(int prod_id);

}
