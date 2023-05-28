package com.example.onlineshopping.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;
import com.example.onlineshopping.model.Product;
import com.example.onlineshopping.service.ProductService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import lombok.SneakyThrows;


public class HomeFragment extends Fragment {
    private RecycleViewProductsAdapter productsAdapter;
    private RecyclerView productsRecycleView;
    private List<Product> products;

    private ProductService productService;

    public HomeFragment() {
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @SneakyThrows
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productService = new ProductService();
        products = productService.getProducts();
        productsRecycleView = view.findViewById(R.id.productRecycleView);
        productsAdapter = new RecycleViewProductsAdapter(getContext(), products);
        productsRecycleView.setAdapter(productsAdapter);
        productsRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}