package com.example.onlineshopping.model;

import java.io.Serializable;



public class Product implements Serializable {
    private String productName;
    private String productImageUrl;
    private String price;


    public Product(String productName, String productImageUrl, String price) {
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.price = price;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getPrice() {
        return this.price;
    }

    public String getProductImageUrl() {
        return this.productImageUrl;
    }
}
