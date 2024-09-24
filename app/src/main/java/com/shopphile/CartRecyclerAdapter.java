package com.shopphile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.CartViewHolder> {

    private final ArrayList<String> productNames;
    private final ArrayList<String> productPrices;
    private final ArrayList<Integer> quantities;
    private final ArrayList<Integer> productImages;


    public CartRecyclerAdapter(ArrayList<String> productNames, ArrayList<String> productPrices, ArrayList<Integer> quantities, ArrayList<Integer> productImages) {
        this.productNames = productNames;
        this.productPrices = productPrices;
        this.quantities = quantities;
        this.productImages = productImages;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.bind(productNames.get(position), productPrices.get(position), quantities.get(position), productImages.get(position));
    }


    @Override
    public int getItemCount() {
        return productNames.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        private final TextView productName;
        private final TextView productPrice;
        private final TextView productQuantity;
        private final ImageView productImage;
        private final ImageButton minusButton;
        private final ImageButton plusButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.item_type);
            productPrice = itemView.findViewById(R.id.item_price);
            productQuantity = itemView.findViewById(R.id.current_quantity);
            productImage = itemView.findViewById(R.id.item_image);
            minusButton = itemView.findViewById(R.id.minusbtn);
            plusButton = itemView.findViewById(R.id.plusbtn);

        }

        public void bind(String name, String price, int quantity, int imageResId) {
            productName.setText(name);
            productPrice.setText(price); // price is now a String
            productQuantity.setText(String.valueOf(quantity));
            productImage.setImageResource(imageResId);
        }
    }
}