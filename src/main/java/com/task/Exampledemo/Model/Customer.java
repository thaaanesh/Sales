package com.task.Exampledemo.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cus_id;

    @Column(name="cus_name")
    private String cus_name;

    @Column(name="address")
    private String address;

    @Column(name="phn_number")
    private long phn_number;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_customer",
            joinColumns= @JoinColumn(name = "cus_id"),
            inverseJoinColumns = @JoinColumn(name = "prod_id"))
    private List<Product> products = new ArrayList<>();

    public Customer(String cus_name, String address, long phn_number, List<Product> products) {
        this.cus_name = cus_name;
        this.address = address;
        this.phn_number = phn_number;
        this.products = products;
    }
    public Customer()
    {

    }
    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhn_number() {
        return phn_number;
    }

    public void setPhn_number(long phn_number) {
        this.phn_number = phn_number;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", cus_name='" + cus_name + '\'' +
                ", address='" + address + '\'' +
                ", phn_number=" + phn_number +
                ", products=" + products +
                '}';
    }
}
