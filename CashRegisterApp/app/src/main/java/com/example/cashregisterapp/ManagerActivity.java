package com.example.cashregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cashregisterapp.Model.Product;
import com.example.cashregisterapp.Model.PurchaseHistory;

import java.util.ArrayList;

public class ManagerActivity extends AppCompatActivity{
    ArrayList<PurchaseHistory> mAHistoryList;
    ArrayList<PurchaseHistory> mAHistoryListdup;
    ArrayList<Product> mAProdctList;
    Button history, restock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);



        history = (Button) findViewById(R.id.history_btn);
        restock = (Button) findViewById(R.id.restock_btn);

        Intent fromMain = getIntent();
        if(!(this.getIntent().getExtras().getParcelableArrayList("listOfHistory")==null)){

            mAHistoryList = this.getIntent().getExtras().getParcelableArrayList("listOfHistory");
            System.out.println("My ManagerActivity History is: \n"+ mAHistoryList);}
        else if(!(this.getIntent().getExtras().getParcelableArrayList("ListOfProd")==null)){
            mAProdctList = this.getIntent().getExtras().getParcelableArrayList("ListOfProd");
            System.out.println("My ManagerActivity ListOfProd is: \n"+ mAProdctList.toString());}
        }

        /*else if(!(this.getIntent().getExtras().getParcelableArrayList("listOfproducts")==null)){

            mAProdctList = this.getIntent().getExtras().getParcelableArrayList("listOfproducts");
            System.out.println("My ManagerActivity History is: \n"+ mAProdctList);}*/

        //fromMainIntents();
    /* public void fromMainIntents(){
        Intent fromMain1 = getIntent();

        if(!(this.getIntent().getExtras().getParcelableArrayList("listOfHistory")==null)){

            mAHistoryList = this.getIntent().getExtras().getParcelableArrayList("listOfHistory");
            System.out.println("My ManagerActivity History is: \n"+ mAHistoryList);}

        else if(!(this.getIntent().getExtras().getParcelableArrayList("listOfproducts")==null)){
            mAProdctList = this.getIntent().getExtras().getParcelableArrayList("listOfproducts");
            System.out.println("My ManagerActivity History is: \n"+ mAProdctList);}
        else{
            System.out.println("something went wrong");
        }

    }*/

    public void btnClicked(View v){
        if (v.equals(history)) {
            //ArrayList<PurchaseHistory> mAHistoryListdup;
            mAHistoryListdup =  mAHistoryList;
            System.out.println("My duplicate history is:"+mAHistoryListdup);

            Intent toHistoryReportActivity = new Intent(this, HistoryReportActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("listOfHistory",mAHistoryListdup);
            toHistoryReportActivity.putExtras(bundle);
            startActivity(toHistoryReportActivity);
            System.out.println("My toHistoryReportActivity History is: \n"+ mAHistoryListdup);
            Toast.makeText(this, "History clicked", Toast.LENGTH_SHORT).show();}
            /*
Intent toMngActivity = new Intent(this, ManagerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("listOfHistory",Historylist);
        toMngActivity.putExtras(bundle);
        startActivity(toMngActivity);
 */
        else if (v.equals(restock)) {
            Intent toRestockActivity = new Intent(this, RestockActivity.class);
            startActivity(toRestockActivity);
            Toast.makeText(this, "Restock clicked", Toast.LENGTH_SHORT).show();
        }
    }
}