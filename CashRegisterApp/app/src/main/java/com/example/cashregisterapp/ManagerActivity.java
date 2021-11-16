package com.example.cashregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerActivity extends AppCompatActivity {

    Button history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        history = (Button) findViewById(R.id.btn_history);
    }

    public void btnClicked(View v){
    Intent toPurchaseReport = new Intent(this, HistoryReportActivity.class);
    startActivity(toPurchaseReport);}

}