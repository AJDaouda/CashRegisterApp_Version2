package com.example.cashregisterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    StoreManager StoreMng = new StoreManager();
    List<Product> productList;
    Context storecontext;
    LayoutInflater inflater;


    public ListViewAdapter(List<Product> list,Context activity_context){// can I change it to storecontext later
        this.productList = list;
        this.storecontext = activity_context;
    }

    @Override
    public int getCount() {
        return StoreMng.listOfProd.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(storecontext).inflate(R.layout.list_view_item,null);
        TextView itemName = (TextView) convertView.findViewById(R.id.prodName);
        TextView itemQnt = (TextView) convertView.findViewById(R.id.prodQnt);
        TextView itemPrice = (TextView) convertView.findViewById(R.id.prodPrice);
        itemName.setText(productList.get(position).getProdName());
        itemQnt.setText(String.valueOf(productList.get(position).getProdQnt()));
        // we can also use
        //itemQnt.setText(productList.get(position).getProdQnt() + "");
        itemPrice.setText(String.valueOf(productList.get(position).getProdPrice()));
        return convertView;

    }

}
