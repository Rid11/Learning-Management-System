package com.alabelewe.learningmanagementsystem.rest;


import com.alabelewe.learningmanagementsystem.entity.Product;
import com.alabelewe.learningmanagementsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable("productId") int productId) {
        Product product = productService.getProductById(productId);

        if(product == null){
            throw new RuntimeException("Product not found");
        }
        return product;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        product.setId(0);

        Product product1 = productService.saveProduct(product);

        return product1;
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        Product product1 = productService.saveProduct(product);

        if(product1 == null){
            throw new RuntimeException("Product not found");
        }
        return product1;
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId) {
        Product product = productService.getProductById(productId);
        if(product == null){
            throw new RuntimeException("Product not found");
        }
        productService.deleteProduct(productId);

        return "Deleted product ID " + productId;
    }
}
