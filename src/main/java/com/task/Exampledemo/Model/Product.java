package com.task.Exampledemo.Model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int  prod_id;

    @Column(name="prod_name")
    private String prod_name;

    @Column(name="prod_des")
    private String prod_des;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_customer",
            joinColumns= @JoinColumn(name = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "cus_id"))
    private List<Customer> customers = new ArrayList<>();

    public Product(String prod_name, String prod_des, List<Customer> customers) {
        this.prod_name = prod_name;
        this.prod_des = prod_des;
        this.customers = customers;
    }
    public Product()
    {

    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_des() {
        return prod_des;
    }

    public void setProd_des(String prod_des) {
        this.prod_des = prod_des;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prod_id=" + prod_id +
                ", prod_name='" + prod_name + '\'' +
                ", prod_des='" + prod_des + '\'' +
                ", customers=" + customers +
                '}';
    }
}

