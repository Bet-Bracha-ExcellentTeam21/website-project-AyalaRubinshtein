package com.example.demo.Product;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(
            name = "ID",
            updatable = false
    )
    private int ID;

    @Column(
            name = "productName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String productName;

    @Column(
            name = "productClass",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String productClass;

    @Column(
            name = "price",
            nullable = false
    )
    private double price;

    @Column(
            name = "pathPicture",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String pathPicture;

    @Column(
            name = "details",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String details;

    public Product() {
    }

    public Product(int ID, String productName, String productClass, double price, String pathPicture, String details) {
        this.ID = ID;
        this.productName = productName;
        this.productClass = productClass;
        this.price = price;
        this.pathPicture = pathPicture;
        this.details = details;
    }

    public Product(String productName, String productClass, double price, String pathPicture, String details) {
        this.productName = productName;
        this.productClass = productClass;
        this.price = price;
        this.pathPicture = pathPicture;
        this.details = details;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPathPicture() {
        return pathPicture;
    }

    public void setPathPicture(String pathPicture) {
        this.pathPicture = pathPicture;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID + '\n' +
                productName + '\n' +
                ", price=" + price +
                ", pathPicture='" + pathPicture + '\'' +
                ", details='" + details + '\'' +
                "}\n";
    }

}