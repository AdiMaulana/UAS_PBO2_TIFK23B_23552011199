package model;

import java.util.Date;

public class Revenue {
    private int id;
    private int clothingId;
    private String clothingName;
    private Date saleDate;
    private int quantity;
    private double pricePerItem;
    private double totalAmount;
    private int customerId;
    private String customerName;
    private double discountAmount;
    private String paymentMethod;

    public Revenue() {
    }

    public Revenue(int id, int clothingId, Date saleDate, int quantity, double pricePerItem, 
            double totalAmount, int customerId, double discountAmount, String paymentMethod) {
        this.id = id;
        this.clothingId = clothingId;
        this.saleDate = saleDate;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
        this.discountAmount = discountAmount;
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClothingId() {
        return clothingId;
    }

    public void setClothingId(int clothingId) {
        this.clothingId = clothingId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getClothingName() {
        return clothingName;
    }

    public void setClothingName(String clothingName) {
        this.clothingName = clothingName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

