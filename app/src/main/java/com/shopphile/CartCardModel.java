package com.shopphile;

public class CartCardModel {

    private String productName;
    private String productPrice; // Now a String
    private int quantity;
    private int imageResourceId; // Change this to int

    // Constructor
    public CartCardModel(String productName, String productPrice, int quantity, int imageResourceId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.imageResourceId = imageResourceId;
    }

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImageResourceId() { // Updated
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) { // Updated
        this.imageResourceId = imageResourceId;
    }

    public String getTotalPrice() {
        try {
            String priceWithoutSymbol = productPrice.replace("₱", "").replace(",", "");
            double price = Double.parseDouble(priceWithoutSymbol);
            double totalPrice = price * quantity;
            return String.format("₱%,.2f", totalPrice);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return productPrice;
        }
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", quantity=" + quantity +
                ", imageResourceId=" + imageResourceId + // Updated
                '}';
    }
}