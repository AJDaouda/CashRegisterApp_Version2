package com.example.cashregisterapp.Model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class PurchaseHistory extends Product implements Parcelable{
    //implements Serializable
    //Declaring instance variables
    //private String purchaseDate;
    private String purchaseDate;

    //Empty constructor
    public PurchaseHistory() { }

    //Custom constructor
    public PurchaseHistory(String prodName, int prodQnt, double prodPrice, String purchaseDate) {
        super(prodName, prodQnt, prodPrice);
        this.purchaseDate = purchaseDate; }

    // Creating a getter to access "purchaseDate"
    public String getPurchaseDate() {
        return purchaseDate;
    }
    //public void setPurchaseDate(String purchaseDate) {this.purchaseDate = purchaseDate;}

    //Create prod array list to add the store items of type "Product"
    private ArrayList<PurchaseHistory> Historylist = new ArrayList<>();

    // Creating a getter to access the "Historylist"
    public ArrayList<PurchaseHistory> getHistorylist() { return Historylist; }

    //Creating a "toString"
    @Override
    public String toString() {
        return "ProductName: " + getProdName() +"\n"+
                "ProductQnt: " + getProdQnt() +"\n"+
                "ProductPrice: " + getProdPrice() +"\n"+
                "purchaseDate=" + purchaseDate; }

    //Implementing Parcelable methods
    protected PurchaseHistory(Parcel in) {
        purchaseDate = in.readString();
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(purchaseDate);
        dest.writeTypedList(Historylist);
    }
}

/*
public class PurchaseHistory extends Product{
    //implements Serializable
    //Declaring instance variables
    //private String purchaseDate;
    private String purchaseDate;

    //Create prod array list to add the store items of type "Product"
    private ArrayList<PurchaseHistory> Historylist = new ArrayList<>();

    //Empty constructor
    public PurchaseHistory() { }

    //Custom constructor
    public PurchaseHistory(String prodName, int prodQnt, double prodPrice, String purchaseDate) {
        super(prodName, prodQnt, prodPrice);
        this.purchaseDate = purchaseDate; }

    // Creating a getter to access "purchaseDate"
    public String getPurchaseDate() {
        return purchaseDate;
    }
    //public void setPurchaseDate(String purchaseDate) {this.purchaseDate = purchaseDate;}

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
 */