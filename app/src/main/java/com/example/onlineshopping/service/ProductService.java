package com.example.onlineshopping.service;

import com.example.onlineshopping.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class ProductService {


    public List<Product> getProducts() {
        Product product1 = new Product("San pham 1", "https://img.muji.net/img/item/4550344275726_1260.jpg", "120000");
        Product product2 = new Product("San pham 2", "https://img.muji.net/img/item/4550344275726_1260.jpg", "120000");
        Product product3 = new Product("San pham 3", "https://img.muji.net/img/item/4550344275726_1260.jpg", "120000");
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        return products;
    }

}
