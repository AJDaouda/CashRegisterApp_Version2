package com.example.cashregisterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cashregisterapp.Model.PurchaseHistory;

import java.util.ArrayList;

public class HistoryListViewAdapter extends RecyclerView.Adapter<HistoryListViewAdapter.viewHolder> {
    Context hContext;
    ArrayList<PurchaseHistory> allHistoryList;


    // inner class
    // View Holder = Row in the table
    // static = able to access it from the class without creating object
    //
    public static class viewHolder extends RecyclerView.ViewHolder{
        private final TextView prodName;
        private final TextView prodQnt;
        private final TextView prodPrice;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            prodName=itemView.findViewById(R.id.RecyclerprodName);
            prodQnt=itemView.findViewById(R.id.RecyclerprodQnt);
            prodPrice=itemView.findViewById(R.id.RecyclerprodPrice); }

        public TextView getProdName() {return prodName;}

        public TextView getProdQnt() {return prodQnt;}

        public TextView getProdPrice() { return prodPrice;}
    }

    HistoryListViewAdapter(Context c, ArrayList<PurchaseHistory> histories){
        hContext = c;
        allHistoryList = histories; }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(hContext).inflate(R.layout.recycler_row_item,parent,false);
        return new viewHolder(view); }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.getProdName().setText(allHistoryList.get(position).getProdName());
        holder.getProdQnt().setText(allHistoryList.get(position).getProdQnt()+"");
        holder.getProdPrice().setText(allHistoryList.get(position).getProdPrice()+"");
    }
    @Override
    public int getItemCount() {return allHistoryList.size(); }
}
/*
public class HistoryListViewAdapter extends RecyclerView.Adapter<HistoryListViewAdapter.viewHolder> {

    Context hContext;
    ArrayList<PurchaseHistory> allHistoryList;
    AdapterView.OnItemClickListener listener;
   // LayoutInflater inflater;
    // inner class
    // View Holder = Row in the tabLe
    // static = able to access it from the class without creating object
    public static class viewHolder extends RecyclerView.ViewHolder {
        private final TextView prodName;
        private final TextView prodQnt;
        private final TextView prodPrice;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            prodName=itemView.findViewById(R.id.RecyclerprodName);
            prodQnt=itemView.findViewById(R.id.RecyclerprodQnt);
            prodPrice=itemView.findViewById(R.id.RecyclerprodPrice);}

            //Creating getters for the final instance viariables of the inner class"viewHolder"
            public TextView getProdName() {return prodName;}
            public TextView getProdQnt() {return prodQnt;}
            public TextView getProdPrice() {return prodPrice;}
    }

   public HistoryListViewAdapter(Context c, ArrayList<PurchaseHistory>histories){
        hContext = c;
        allHistoryList = histories;
        //this.listener = listener;
        //this.inflater = LayoutInflater.from(hContext);
    }
    @NonNull
    @Override
    //public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(hContext).inflate(R.layout.recycler_row_item,parent,false);
       return new viewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.getProdName().setText(allHistoryList.get(position).getProdName());
        //holder.getProdQnt().setText(String.valueOf(allHistoryList.get(position).getProdQnt()));
        //holder.getProdPrice().setText(String.valueOf(allHistoryList.get(position).getProdPrice()))

    }

    @Override
    public int getItemCount() {
        return allHistoryList.size();
    }
}
 */