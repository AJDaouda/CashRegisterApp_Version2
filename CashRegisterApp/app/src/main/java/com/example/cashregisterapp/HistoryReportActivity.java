package com.example.cashregisterapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.cashregisterapp.Model.Product;
import com.example.cashregisterapp.Model.PurchaseHistory;
import com.example.cashregisterapp.Model.StoreManager;

import java.util.ArrayList;

public class HistoryReportActivity extends AppCompatActivity {
    //static PurchaseHistory hObj = new PurchaseHistory();
    ArrayList<PurchaseHistory> allHistoryList;
    //Creating receiver Intent
    ActivityResultLauncher<Intent> newHistoryActivityResultLauncher;
    HistoryListViewAdapter hCustomAdapter;
    RecyclerView HistoryRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (savedInstanceState != null)
            historylist = savedInstanceState.getParcelableArrayList("allHistory");
        else
            historylist = new ArrayList<>(0);*/

        setContentView(R.layout.activity_history_report);
        //getIntent().getExtras().getInt;
        HistoryRV=(RecyclerView) findViewById(R.id.HistoryRecyclerView);
        HistoryRV.setLayoutManager(new LinearLayoutManager(this));
        hCustomAdapter = new HistoryListViewAdapter(this, allHistoryList);
        HistoryRV.setAdapter(hCustomAdapter);


        newHistoryActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            PurchaseHistory receivedHistory = data.getParcelableExtra("History");
                            allHistoryList.add(receivedHistory);
                            hCustomAdapter.notifyDataSetChanged();
                            System.out.println(allHistoryList.toString());
                        }
                    }
                }
        );
    }

    /*  @Override
   protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("allHistory",allHistoryList);
    }*/
}