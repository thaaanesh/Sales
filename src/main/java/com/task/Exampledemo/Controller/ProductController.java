package com.task.Exampledemo.Controller;

import com.task.Exampledemo.Model.Product;
import com.task.Exampledemo.Service.CustomerService;
import com.task.Exampledemo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService theProductService;
    @Autowired
    public ProductController(ProductService theProductService) {
        this.theProductService = theProductService;
    }
    @PostMapping
    public Product addProduct(@RequestBody Product theProduct)
    {
        return theProductService.save(theProduct);
    }
    @GetMapping
    public List<Product> findAll()
    {
        return theProductService.findAll();
    }

    @GetMapping("/{prod_id}")
    public Product findById(@PathVariable int prod_id)
    {
        Product theProduct=theProductService.findById(prod_id);
        if(theProduct==null)
        {
            throw new RuntimeException("id not found" +prod_id);
        }
        return theProduct;
    }
    @PutMapping("/{prod_id}")
    public Product updateProduct(@PathVariable int prod_id,@RequestBody Product updateProduct)
    {
        return theProductService.updateProduct(prod_id,updateProduct);
    }
    @DeleteMapping("/{prod_id}")
    public void deleteProduct(@PathVariable int prod_id)
    {
        theProductService.deleteById(prod_id);
    }

//    @GetMapping("/products/customer")
//    public String findProductNameByCustomerId(@RequestParam Integer cus_id) {
//        String productName = theProductService.findProductNameByCustomerId(cus_id);
//        if(productName != null) {
//            return productName;
//        } else {
//            return "Product not found";
//        }
//    }

}
