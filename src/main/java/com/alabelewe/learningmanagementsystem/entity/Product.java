package com.alabelewe.learningmanagementsystem.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="products")
public class Product{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    @Column(name="created_at")
    private Date createAt;

    @Column(name="status")
    private String status;

    public Product() {

    }

    public Product(int id, String title, String description, double price, Date createAt, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createAt=" + createAt +
                ", status='" + status + '\'' +
                '}';
    }
}
