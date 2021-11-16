package com.example.cashregisterapp.Model;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseHistory extends Product {
    //implements Serializable
    //Declaring instance variables
    private Date purchaseDate;

    //Create prod array list to add the store items of type "Product"
    private ArrayList<PurchaseHistory> Historylist = new ArrayList<>();

    //Empty constructor
    public PurchaseHistory() { }

    //Custom constructor
    public PurchaseHistory(String prodName, int prodQnt, double prodPrice, Date purchaseDate) {
        super(prodName, prodQnt, prodPrice);
        this.purchaseDate = purchaseDate; }

    // Creating a getter and getter to access "purchaseDate"
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    // Creating a getter to access the "Historylist"
    public ArrayList<PurchaseHistory> getHistorylist() { return Historylist; }

    //Creating a "toString"
    @Override
    public String toString() {
        return "ProductName: " + getProdName() +"\n"+
                "ProductQnt: " + getProdQnt() +"\n"+
                "ProductPrice: " + getProdPrice() +"\n"+
                "purchaseDate=" + purchaseDate;
    }
}
