package com.example.cashregisterapp;

import java.util.Date;

public class PurchaseHistory extends Product{
    private Date purchaseDate;

    public PurchaseHistory() { }

    public PurchaseHistory(String prodName, int prodQnt, double prodPrice, Date purchaseDate) {
        super(prodName, prodQnt, prodPrice);
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
