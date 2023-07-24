package com.example.springbootcrudapi.service;

import com.example.springbootcrudapi.entity.Product;
import com.example.springbootcrudapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    //Post Method
    public Product saveProduct(Product product){
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //Get Method
    public List<Product> getProducts() {
        return repository.findAll();
    }
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    //Delete
    public String deleteProduct(int id) {
       repository.deleteById(id);
       return "Product Removed !!"+id;
    }
    //Update
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
