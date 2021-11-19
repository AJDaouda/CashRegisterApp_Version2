package com.example.cashregisterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cashregisterapp.Model.PurchaseHistory;

import java.util.ArrayList;

public class HistoryReportActivity extends AppCompatActivity {
    RecyclerView historyRecyclerview;
    TextView historytextview;
    ArrayList<PurchaseHistory> myhistorylist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_report);
        Intent frommangerintent = getIntent();
        historytextview = findViewById(R.id.historytextView);
        historytextview.setVisibility(View.INVISIBLE);
        historyRecyclerview = findViewById(R.id.HistoryRecyclerView);
        historyRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        if(!(this.getIntent().getExtras().getParcelableArrayList("listOfHistory").isEmpty()))
        {
            myhistorylist = this.getIntent().getExtras().getParcelableArrayList("listOfHistory");
            //System.out.println(myhistorylist);
            HistoryListViewAdapter adapter = new HistoryListViewAdapter(this, myhistorylist);
            //adapter.listener = this;
            historyRecyclerview.setAdapter(adapter);
        }
        else {System.out.println("Empty History");
            historytextview.setText("NO PURCHASE HISTORY");
            historytextview.setVisibility(View.VISIBLE);
            historyRecyclerview.setVisibility(View.INVISIBLE);
        }
//        System.out.println("Printing History in HistoryActivity:");
//
    }

    /*@Override
    public void onCarSelected(Car selectedCar) {
        Toast.makeText(this,selectedCar.car_model + " is Selected",Toast.LENGTH_LONG ).show();
    }*/
}


/*
   RecyclerView HistoryRV;
    ArrayList<PurchaseHistory> hRHistoryList;
    ArrayList<PurchaseHistory> hRHistoryListdup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent fromManagerActivity = getIntent();
        if(!(this.getIntent().getExtras().getParcelableArrayList("listOfHistory")==null)){

            hRHistoryList = this.getIntent().getExtras().getParcelableArrayList("listOfHistory");
            System.out.println("My HistoryReportActivity History is: \n"+ hRHistoryList);}

        hRHistoryListdup=hRHistoryList;

        HistoryRV =  findViewById(R.id.HistoryRecyclerView);
        HistoryRV = (RecyclerView) findViewById(R.id.HistoryRecyclerView);
        HistoryRV.setLayoutManager(new LinearLayoutManager(this));


        HistoryListViewAdapter adapter = new HistoryListViewAdapter(this,hRHistoryListdup);
        //HistoryListViewAdapter hCustomAdapter;
        //adapter.listener = this;
        HistoryRV.setAdapter(adapter);
    }
**/

/*
public class HistoryReportActivity extends AppCompatActivity {
    ArrayList<PurchaseHistory> hRHistoryList;

    HistoryListViewAdapter hCustomAdapter;
    RecyclerView HistoryRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        HistoryRV=(RecyclerView) findViewById(R.id.HistoryRecyclerView);

        HistoryRV.setLayoutManager(new LinearLayoutManager(this));
        hCustomAdapter = new HistoryListViewAdapter(this, hRHistoryList);
        System.out.println("I'm here");



        Intent fromMangerActivity = getIntent();

       //if(!(this.getIntent().getExtras().getParcelableArrayList("listOfHistory")==null)){
            if(!(fromMangerActivity.getExtras().getParcelableArrayList("listOfHistory")).isEmpty()){
            hRHistoryList = this.getIntent().getExtras().getParcelableArrayList("listOfHistory");
            System.out.println("My HistoryReportActivity History is: \n"+ hRHistoryList);
            HistoryRV.setAdapter(hCustomAdapter);
            //HistoryRV.setAdapter(new HistoryListViewAdapter(this,hRHistoryList));
        }
        else{
            System.out.println("something went wrong");
        }
    }
}
*/

/*
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

     /*   setContentView(R.layout.activity_history_report);
        //getIntent().getExtras().getInt;
        HistoryRV=(RecyclerView) findViewById(R.id.HistoryRecyclerView);
        HistoryRV.setLayoutManager(new LinearLayoutManager(this));
        hCustomAdapter = new HistoryListViewAdapter(this, allHistoryList);
        HistoryRV.setAdapter(hCustomAdapter);*/

/*
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
    }*/

    /*  @Override
   protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("allHistory",allHistoryList);
    }*/