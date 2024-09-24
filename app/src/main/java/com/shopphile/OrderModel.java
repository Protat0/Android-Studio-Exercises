package com.shopphile;

public class OrderModel {
    private String orderNumber;
    private String orderDate;
    private String itemName;
    private String itemPrice;
    private int itemImage; // Could be a resource ID or a URL if using images from the web
    private String statusOrdered;
    private String statusProcessing;
    private String statusPacked;
    private String statusShipped;
    private String statusDelivered;

    // Constructor
    public OrderModel(String orderNumber, String orderDate, String itemName, String itemPrice, int itemImage,
                      String statusOrdered, String statusProcessing, String statusPacked,
                      String statusShipped, String statusDelivered) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.statusOrdered = statusOrdered;
        this.statusProcessing = statusProcessing;
        this.statusPacked = statusPacked;
        this.statusShipped = statusShipped;
        this.statusDelivered = statusDelivered;
    }

    // Getters
    public String getOrderNumber() {
        return orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }

    public String getStatusOrdered() {
        return statusOrdered;
    }

    public String getStatusProcessing() {
        return statusProcessing;
    }

    public String getStatusPacked() {
        return statusPacked;
    }

    public String getStatusShipped() {
        return statusShipped;
    }

    public String getStatusDelivered() {
        return statusDelivered;
    }

    // Setters (if needed)
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public void setStatusOrdered(String statusOrdered) {
        this.statusOrdered = statusOrdered;
    }

    public void setStatusProcessing(String statusProcessing) {
        this.statusProcessing = statusProcessing;
    }

    public void setStatusPacked(String statusPacked) {
        this.statusPacked = statusPacked;
    }

    public void setStatusShipped(String statusShipped) {
        this.statusShipped = statusShipped;
    }

    public void setStatusDelivered(String statusDelivered) {
        this.statusDelivered = statusDelivered;
    }
}
