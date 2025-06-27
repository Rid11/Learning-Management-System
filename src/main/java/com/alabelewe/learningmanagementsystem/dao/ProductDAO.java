package com.alabelewe.learningmanagementsystem.dao;

import com.alabelewe.learningmanagementsystem.entity.Product;

import java.util.List;

public interface ProductDAO{

    List<Product> findAll();

    Product findById(int id);

    Product save(Product product);

    void deleteById(int id);

}
