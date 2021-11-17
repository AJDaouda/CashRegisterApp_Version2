package com.example.cashregisterapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
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
    //public ArrayList<? extends Parcelable> getHistorylist() { return Historylist; }
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

/* */
/* public class PurchaseHistory extends Product implements Parcelable{ //implements Parcelable
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
    //public ArrayList<? extends Parcelable> getHistorylist() { return Historylist; }
    public ArrayList<PurchaseHistory> getHistorylist() { return Historylist; }

    protected PurchaseHistory(Parcel in) {
        Historylist = in.createTypedArrayList(PurchaseHistory.CREATOR);
    }

    public static final Creator<PurchaseHistory> CREATOR = new Creator<PurchaseHistory>() {
        @Override
        public PurchaseHistory createFromParcel(Parcel in) {
            return new PurchaseHistory(in);
        }

        @Override
        public PurchaseHistory[] newArray(int size) {
            return new PurchaseHistory[size];
        }
    };



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(Historylist);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //Creating a "toString"
    @Override
    public String toString() {
        return "ProductName: " + getProdName() +"\n"+
                "ProductQnt: " + getProdQnt() +"\n"+
                "ProductPrice: " + getProdPrice() +"\n"+
                "purchaseDate=" + purchaseDate;
    }
}*/
/*
public class PurchaseHistory extends Product implements Serializable { //implements Serializable
    //implements Serializable
    //Declaring instance variables
    private Date purchaseDate;

    //Create prod array list to add the store items of type "Product"
    private ArrayList<PurchaseHistory> Historylist = new ArrayList<>();

    //Empty constructor
    public PurchaseHistory() {
    }

    //Custom constructor
    public PurchaseHistory(String prodName, int prodQnt, double prodPrice, Date purchaseDate) {
        super(prodName, prodQnt, prodPrice);
        this.purchaseDate = purchaseDate;
    }

    // Creating a getter and getter to access "purchaseDate"
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    // Creating a getter to access the "Historylist"
    //public ArrayList<? extends Parcelable> getHistorylist() { return Historylist; }
    public ArrayList<PurchaseHistory> getHistorylist() {
        return Historylist;
    }

    //Creating a "toString"
    @Override
    public String toString() {
        return "ProductName: " + getProdName() + "\n" +
                "ProductQnt: " + getProdQnt() + "\n" +
                "ProductPrice: " + getProdPrice() + "\n" +
                "purchaseDate=" + purchaseDate;
    }
}*/