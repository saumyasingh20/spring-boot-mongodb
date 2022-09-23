package com.example.springbootmongodb8.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springbootmongodb8.entity.Product;
import com.example.springbootmongodb8.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        try {
            return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> listProducts(){
        try{
            List<Product> allProducts = productService.listProducts();
            if(allProducts.size()==0)
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(allProducts,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") String id){
        try{
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") String id){
        try{
            return new ResponseEntity<>(productService.updateProduct(product,id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/manufacturer/{manu}")
    public ResponseEntity <List<Product>> getProductsByManufacturer(@PathVariable("manu") String manu){
        try{
            List<Product> Products = productService.getProductsByManufacturer(manu.toLowerCase());
            if(Products.size()==0)
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(Products,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable("name") String name){

        try{
            List<Product> Products = productService.getProductsByName(name.toLowerCase());
            if(Products.size()==0)
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(Products,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<Product>> getProductsByPrice(@PathVariable("price") Double price){
        try{
            List<Product> Products = productService.getProductsByPrice(price);
            if(Products.size()==0)
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(Products,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable("id") String id){
        try{
            Product productToBeFound = productService.getProductById(id);
            if(productToBeFound==null)
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(productToBeFound,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


