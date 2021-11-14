package com.example.cashregisterapp;

import java.util.ArrayList;

public class StoreManager {
    //Create prod array list
    // connect to custom adapter to show in prod list

    ArrayList<Product> listOfProd = new ArrayList<>();

    Product shirt=new Product("Shirts  "+"\uD83D\uDC54", 50, 19.99);
    // or Product shirt=new Product("Shirts  "+"🥼", 50, 19.99);
    // To use the emoji keyboard, do long press windows icon + .or;
    Product pant =new Product("Pants  "+"\uD83D\uDC56", 40, 20.44);
    Product shoe =new Product("Shoes  "+"\uD83E\uDD7E", 30, 10.44);
    Product hat =new Product("Hats  "+"\uD83C\uDFA9", 10, 5.99);

    public StoreManager() {
        this.listOfProd.add(pant);
        this.listOfProd.add(shirt);
        this.listOfProd.add(shoe);
        this.listOfProd.add(hat);
    }

    //Checks the product inventory when a client wants to buy
    boolean checkInventory(Product inventory, int clientQnt){
        if(clientQnt>inventory.getProdQnt()){
            return false;
        }
        else{
            return true;
        }
    }
}
