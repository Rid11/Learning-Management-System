package com.alabelewe.learningmanagementsystem.dao;

import com.alabelewe.learningmanagementsystem.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDAO{

    private EntityManager entityManager;


    //Dependency injection using constructor injection
    public ProductDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> findAll() {

        TypedQuery<Product> query = entityManager.createQuery("FROM Product", Product.class);

        List<Product> products = query.getResultList();

        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public Product save(Product product) {

        return entityManager.merge(product);
    }

    @Override
    public void deleteById(int id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
    }


}
