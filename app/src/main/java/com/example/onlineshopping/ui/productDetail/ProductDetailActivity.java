package com.example.onlineshopping.ui.productDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlineshopping.R;
import com.example.onlineshopping.model.Product;
import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends AppCompatActivity {

    private Product product;

    private ImageView productImage;
    private TextView price;
    private Button buyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");
        System.out.println(product.getProductName());
        setTitle(product.getProductName());
        productImage = findViewById(R.id.product_detail_image);
        price = findViewById(R.id.product_detail_price);
        buyButton = findViewById(R.id.buy_button);
        price.setText("Price: " + product.getPrice() + " vnd");
        Picasso.get().load(product.getProductImageUrl()).into(productImage);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}