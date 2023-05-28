package com.example.onlineshopping.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;
import com.example.onlineshopping.model.Product;
import com.example.onlineshopping.ui.productDetail.ProductDetailActivity;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.CropSquareTransformation;

public class RecycleViewProductsAdapter extends RecyclerView.Adapter<RecycleViewProductsAdapter.RecycleViewProductsHolder> {

    private Context context;
    private List<Product> products;
    private ArrayList<Product> productsArrayList;

    public RecycleViewProductsAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
        this.productsArrayList = new ArrayList<Product>();
        this.productsArrayList.addAll(products);
    }


    @NonNull
    @NotNull
    @Override
    public RecycleViewProductsHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.product_item, parent, false);
        return new RecycleViewProductsHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull RecycleViewProductsHolder holder, int position) {
        holder.productName.setText(productsArrayList.get(position).getProductName());
        holder.price.setText("Price: " + productsArrayList.get(position).getPrice() + " vnd");
        holder.productItemCardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("product", products.get(holder.getAdapterPosition()));
            context.startActivity(intent);
        });
        Picasso.get().load(productsArrayList.get(position).getProductImageUrl()).transform(new CropSquareTransformation()).into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    static class RecycleViewProductsHolder extends RecyclerView.ViewHolder {

        final TextView productName;
        final ImageView productImage;
        final TextView price;
        public View productItemCardView;

        public RecycleViewProductsHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_item_name);
            productImage = itemView.findViewById(R.id.product_item_image);
            price = itemView.findViewById(R.id.price);
            productItemCardView = itemView.findViewById(R.id.product_item_card_view);
        }
    }
}