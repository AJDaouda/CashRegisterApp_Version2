package com.example.cashregisterapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable{
    //Declaring instance variables
    private String prodName;
    private int prodQnt;
    private double prodPrice;

    //Empty constructor
   public Product(){}

    //Custom constructor
    public Product(String prodName, int prodQnt, double prodPrice) {
        this.prodName = prodName;
        this.prodQnt = prodQnt;
        this.prodPrice = prodPrice; }

    //creating getters for the class instance variables
    public String getProdName() { return prodName; }
    public int getProdQnt() {return prodQnt; }
    public double getProdPrice() { return prodPrice; }

    //creating setters for the class instance variables
    public void setProdName(String prodName) {this.prodName = prodName; }
    public void setProdQnt(int prodQnt) {this.prodQnt = prodQnt;}
    public void setProdPrice(double prodPrice) { this.prodPrice = prodPrice; }

    //Implementing Parcelable methods
    protected Product(Parcel in) {
        prodName = in.readString();
        prodQnt = in.readInt();
        prodPrice = in.readDouble();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(prodName);
        dest.writeInt(prodQnt);
        dest.writeDouble(prodPrice);
    }
}
/*
public class Product {
    //Declaring instance variables
    private String prodName;
    private int prodQnt;
    private double prodPrice;

    //Empty constructor
   public Product(){}

    //Custom constructor
    public Product(String prodName, int prodQnt, double prodPrice) {
        this.prodName = prodName;
        this.prodQnt = prodQnt;
        this.prodPrice = prodPrice; }

    //creating getters for the class instance variables
    public String getProdName() { return prodName; }
    public int getProdQnt() {return prodQnt; }
    public double getProdPrice() { return prodPrice; }

    //creating setters for the class instance variables
    public void setProdName(String prodName) {this.prodName = prodName; }
    public void setProdQnt(int prodQnt) {this.prodQnt = prodQnt;}
    public void setProdPrice(double prodPrice) { this.prodPrice = prodPrice; }
}
 */

