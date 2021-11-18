package com.example.cashregisterapp.Model;

import java.util.ArrayList;

public class StoreManager {
    //Declaring instance variables
    //Create prod array list to add the store items of type "Product"
    // connect to custom adapter to show in prod list
    private ArrayList<Product> listOfProd = new ArrayList<>();

    // Creating the store items products
    Product shirt=new Product("Shirts  "+"\uD83D\uDC54", 50, 19.99);
    // or Product shirt=new Product("Shirts  "+"🥼", 50, 19.99);
    // To use the emoji keyboard, do long press windows icon + .or;
    Product pant =new Product("Pants  "+"\uD83D\uDC56", 40, 20.44);
    Product shoe =new Product("Shoes  "+"\uD83E\uDD7E", 30, 10.44);
    Product hat =new Product("Hats  "+"\uD83C\uDFA9", 10, 5.99);


    //Empty constructor
    /*public StoreManager() {}*/

    //Custom constructor
    public StoreManager() {
        this.listOfProd.add(pant);
        this.listOfProd.add(shirt);
        this.listOfProd.add(shoe);
        this.listOfProd.add(hat); }

    // Creating a getter to access the "listOfProd"
    public ArrayList<Product> getListOfProd() {return listOfProd;}

    //Checks the product inventory when a client wants to buy
    public boolean checkInventory(Product inventory, int clientQnt){
        if(clientQnt>inventory.getProdQnt()){
            return false; }
        else{
            return true; } }
}
