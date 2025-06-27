package com.alabelewe.learningmanagementsystem.service;

import com.alabelewe.learningmanagementsystem.dao.ProductDAO;
import com.alabelewe.learningmanagementsystem.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        return productDAO.findById(id);
    }
    @Override
    @Transactional
    public Product saveProduct(Product theProduct) {
        return productDAO.save(theProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productDAO.deleteById(id);
    }



}
