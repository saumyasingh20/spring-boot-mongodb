package com.example.springbootmongodb8.service;

import com.example.springbootmongodb8.entity.Product;
import com.example.springbootmongodb8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        product.setName(product.getName().toLowerCase());
        product.setManu(product.getManu().toLowerCase());
        return productRepository.save(product);
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product prod, String id) {
        Product prodToBeUpdated = productRepository.findById(id).get();
        prodToBeUpdated.setName(prod.getName());
        prodToBeUpdated.setDesc(prod.getDesc());
        prodToBeUpdated.setPrice(prod.getPrice());
        prodToBeUpdated.setManu(prod.getManu());
        return productRepository.save(prodToBeUpdated);

    }

    @Override
    public List<Product> getProductsByManufacturer(String manu) {
        return productRepository.findProductsByManu(manu);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public List<Product> getProductsByPrice(Double price) {
        List<Product> products = new ArrayList<>();
        for(Double i = price; i<=price+5000; i++){
            products.addAll(productRepository.findProductsByPrice(i));
        }
        return products;
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).get();
    }
}

