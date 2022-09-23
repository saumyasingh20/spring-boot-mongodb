package com.example.springbootmongodb8.service;

import java.util.List;
import com.example.springbootmongodb8.entity.Product;
public interface ProductService {
    public Product addProduct(Product product);
    public List<Product> listProducts();
    public void deleteProduct(String id);
    public Product updateProduct(Product prod,String id);

    public List<Product> getProductsByManufacturer(String manu);
    public List<Product> getProductsByName(String name);
    public List<Product> getProductsByPrice(Double price);

    public Product getProductById(String id);

}
