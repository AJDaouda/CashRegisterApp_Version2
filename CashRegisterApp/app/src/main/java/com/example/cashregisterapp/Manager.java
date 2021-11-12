package com.example.cashregisterapp;

import java.util.ArrayList;

public class Manager {
    //Create prod array list
    // connect to custom adapter to show in prod list

    ArrayList<Product> listOfProd = new ArrayList<>();

    Product shirt=new Product("Shirts", 50, 19.99);
    Product pant =new Product("Pants", 40, 20.44);
    Product shoe =new Product("Shoes", 30, 10.44);
    Product hat =new Product("Hats", 10, 5.99);
    public Manager() {
        this.listOfProd.add(pant);
        this.listOfProd.add(shirt);
        this.listOfProd.add(shoe);
        this.listOfProd.add(hat);
    }

    boolean checkInventory(Product inventory, int clientQnt){
        if(clientQnt>inventory.getProdQnt()){
            return false;
        }
        else{
            return true;
        }
    }

}
