package com.example.cashregisterapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ListViewCustomAdapter  extends BaseAdapter {

    Manager StoreMng = new Manager();

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
        return null;
    }
}
