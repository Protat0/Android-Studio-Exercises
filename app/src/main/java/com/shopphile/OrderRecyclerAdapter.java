package com.shopphile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.OrderViewHolder> {

    private final ArrayList<String> productNames;
    private final ArrayList<String> productPrices;
    private final ArrayList<Integer> quantities;
    private final ArrayList<Integer> productImages;
    private final ArrayList<String> orderNumbers; // Keep as Integer
    private final ArrayList<String> orderDates; // Keep as String

    public OrderRecyclerAdapter(ArrayList<String> productNames, ArrayList<String> productPrices, ArrayList<Integer> quantities, ArrayList<Integer> productImages, ArrayList<String> orderNumbers, ArrayList<String> orderDates) {
        this.productNames = productNames;
        this.productPrices = productPrices;
        this.quantities = quantities;
        this.productImages = productImages;
        this.orderNumbers = orderNumbers;
        this.orderDates = orderDates;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.bind(
                productNames.get(position),
                productPrices.get(position),
                productImages.get(position),
                orderNumbers.get(position),
                orderDates.get(position)
        );
    }

    @Override
    public int getItemCount() {
        return productNames.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemName;
        private final TextView itemPrice;
        private final TextView orderId;
        private final TextView orderDate;
        private final ImageView itemImage;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            orderId = itemView.findViewById(R.id.order_number);
            orderDate = itemView.findViewById(R.id.order_date);
            itemImage = itemView.findViewById(R.id.item_image);
        }

        public void bind(String name, String price, int imageResId, String orderIdText, String orderDateText) {
            itemName.setText(name);
            itemPrice.setText(price);
            orderId.setText(orderIdText);
            orderDate.setText(orderDateText);
            itemImage.setImageResource(imageResId);
        }
    }
}


