package com.example.cashregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cashregisterapp.Model.PurchaseHistory;

public class ManagerActivity extends AppCompatActivity {

    Button history, restock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        history = (Button) findViewById(R.id.history_btn);
        restock = (Button) findViewById(R.id.restock_btn);
       /* if (getIntent().hasExtra(HistoryList)){
            // PurchaseHistory shopperPH = getIntent().getExtras().getParcelable("HistoryList");
            // System.out.println(shopperPH.toString());
        }*/
    }

    public void btnClicked(View v){
        if (v.equals(history)) {
            Intent toPurchaseReport = new Intent(this, HistoryReportActivity.class);
            startActivity(toPurchaseReport);
            Toast.makeText(this, "History clicked", Toast.LENGTH_SHORT).show();
        } else if (v.equals(restock)) {
            Intent toRestockActivity = new Intent(this, RestockActivity.class);
            startActivity(toRestockActivity);
            Toast.makeText(this, "Restock clicked", Toast.LENGTH_SHORT).show();
        }
    }
}