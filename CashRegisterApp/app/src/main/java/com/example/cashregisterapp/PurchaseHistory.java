package com.example.cashregisterapp;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseHistory extends Product{
    private Date purchaseDate;
    ArrayList<PurchaseHistory> Historylist = new ArrayList<>();


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

    @Override
    public String toString() {
        return "ProductName: " + getProdName() +"\n"+
                "ProductQnt: " + getProdQnt() +"\n"+
                "ProductPrice: " + getProdPrice() +"\n"+
                "purchaseDate=" + purchaseDate;
    }
}
