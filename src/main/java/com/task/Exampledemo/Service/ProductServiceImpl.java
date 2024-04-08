package com.task.Exampledemo.Service;

import com.task.Exampledemo.Model.Product;
import com.task.Exampledemo.Repository.CustomerRepository;
import com.task.Exampledemo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public  class ProductServiceImpl implements ProductService{
    private ProductRepository theProductRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository theProductRepository) {
        this.theProductRepository = theProductRepository;
    }
    @Transactional
    @Override
    public Product save(Product theProduct) {
        return theProductRepository.save(theProduct);
    }

    @Override
    public List<Product> findAll() {
        return theProductRepository.findAll();
    }

    @Override
    public Product findById(int prod_id) {
        Optional<Product> result=theProductRepository.findById(prod_id);
        Product theProduct=null;
        if(result.isPresent())
        {
            theProduct=result.get();
        }
        else
        {
            throw new RuntimeException("id not found" +prod_id);
        }
        return theProduct;
    }

    @Override
    @Transactional
    public Product updateProduct(int prod_id, Product updateProduct) {
       Product existingTheProduct=theProductRepository.findById(prod_id).orElse(null);
       if(existingTheProduct!=null)
       {
           existingTheProduct.setProd_des(updateProduct.getProd_des());
           existingTheProduct.setProd_name(updateProduct.getProd_name());
           //existingTheProduct.setProd_id(updateProduct.getProd_id());
           return theProductRepository.save(existingTheProduct);

       }
       return null;
    }
    @Override
    @Transactional
    public void deleteById(int prod_id) {
        theProductRepository.deleteById(prod_id);
    }

//    @Override
//    public String findProductNameByCustomerId(Integer cus_id) {
//        return theProductRepository.findProductNameByCustomerId(cus_id);
//    }
}
