package com.alabelewe.learningmanagementsystem.service;

import com.alabelewe.learningmanagementsystem.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public Product saveProduct(Product theProduct);
    public void deleteProduct(int id);

}
