package com.example.cashregisterapp.Model;

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
    public int getProdQnt() {
        return prodQnt;
    }
    public double getProdPrice() { return prodPrice; }

    //creating setters for the class instance variables
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
    public void setProdQnt(int prodQnt) {
        this.prodQnt = prodQnt;
    }
    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }
}
