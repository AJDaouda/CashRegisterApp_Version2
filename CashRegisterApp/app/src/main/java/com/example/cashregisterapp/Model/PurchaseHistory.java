package com.example.cashregisterapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class PurchaseHistory extends Product implements Parcelable {
    private String purchaseDate;

    //Empty constructor
   // public PurchaseHistory() { }

    //Custom constructor
    public PurchaseHistory(String prodName, int prodQnt, double prodPrice, String purchaseDate) {
        super(prodName, prodQnt, prodPrice);
        this.purchaseDate = purchaseDate; }

    public String getPurchaseDate() {return purchaseDate;}


    //Implementing Parcelable methods
    protected PurchaseHistory(Parcel in) {
        super(in);
        purchaseDate = in.readString();
        /*prodName = in.readString();
        prodQnt = in.readInt();
        prodPrice = in.readDouble();*/
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
        super.writeToParcel(dest,flags);
        dest.writeString(purchaseDate);
        /*dest.writeString(prodName);
        dest.writeInt(prodQnt);
        dest.writeDouble(prodPrice);*/
    }

    //Creating a "toString"
    @Override
    public String toString() {
        return "ProductName: " + getProdName() +"\n"+
                "ProductQnt: " + getProdQnt() +"\n"+
                "ProductPrice: " + getProdPrice() +"\n"+
                "purchaseDate=" + purchaseDate; }

}
