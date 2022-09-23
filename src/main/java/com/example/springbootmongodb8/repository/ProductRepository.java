package com.example.springbootmongodb8.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.springbootmongodb8.entity.Product;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {

    @Query("{name:'?0'}")
    List<Product> findProductByName(String name);

    @Query(value = "{manu:'?0'}",fields = "{'name':1,'desc':1,'manu':1,'price':1}")
    List<Product> findProductsByManu(String manu);

    @Query(value = "{price:'?0'}",fields = "{'name':1,'desc':1,'manu':1,'price':1}")
    List<Product> findProductsByPrice(Double price);



}
