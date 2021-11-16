package com.example.cashregisterapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //External class objects declaration
    ListViewAdapter customAdapter;//To access the "ListViewAdapter" class
    static StoreManager mngObj = new StoreManager(); //To access the "StoreManager" class


    //Instance variables declaration
    String qntStr = "";//String to be displayed when the client enter a quantity for a specific item
    int userQnt;
    int newProdQnt;
    int selectedIndex;
    double total;
    double nullTotal=0;

    //Layout Widgets declaration
    Button one, two, three, four, five, six, seven, eight, nine, zero;// digit pad
    Button clear, buy;//clear button
    TextView itemQntTV; //Displays client's quantity
    TextView purchasePrice;
    TextView itemSelectedTV;//Displays the selected item from the list of products
    ListView catalogue;//Displays the list of products that the store holds
    AlertDialog.Builder builder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Finding layout widgets bu id
        zero = (Button) findViewById(R.id.btn_0);
        one = (Button) findViewById(R.id.btn_1);
        two = (Button) findViewById(R.id.btn_2);
        three = (Button) findViewById(R.id.btn_3);
        four = (Button) findViewById(R.id.btn_4);
        five = (Button) findViewById(R.id.btn_5);
        six = (Button) findViewById(R.id.btn_6);
        seven = (Button) findViewById(R.id.btn_7);
        eight = (Button) findViewById(R.id.btn_8);
        nine = (Button) findViewById(R.id.btn_9);

        clear = (Button) findViewById(R.id.btn_Clear);
        buy = (Button) findViewById(R.id.BuyBtn);
        itemQntTV = (TextView) findViewById(R.id.qnt);
        purchasePrice= (TextView) findViewById(R.id.cost);
        itemSelectedTV = (TextView) findViewById(R.id.selectedprod);
        catalogue = (ListView) findViewById(R.id.listViewid);

        // Instantiating the "customAdapter" created above
        customAdapter = new ListViewAdapter(mngObj.listOfProd,this);
        catalogue.setAdapter(customAdapter);// Setting "customAdapter" as the adapter to be used by the "catalogue" listview

        builder = new AlertDialog.Builder(this);
        //
        catalogue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = position;
                itemSelectedTV.setText(mngObj.listOfProd.get(selectedIndex).getProdName());

            }
        });
    }

    //Calculates the amount due for a purchase
    private double calculateTotal(){
        userQnt = Integer.parseInt(itemQntTV.getText().toString());
        double price = mngObj.listOfProd.get(selectedIndex).getProdPrice();
        total = userQnt*price;
        purchasePrice.setText(String.format("$%,.2f", total));
        System.out.println("Item:" + mngObj.listOfProd.get(selectedIndex).getProdName()+
                "\n" + "Qnt: " + userQnt +
                "\n" + "Total: $ "+ total);
        return total; }

    //Decrease the inventory for each item when a purchase is completed
    private void updateInventoryQnt(){
        newProdQnt = mngObj.listOfProd.get(selectedIndex).getProdQnt()-userQnt;
        mngObj.listOfProd.get(selectedIndex).setProdQnt(newProdQnt);
        System.out.println(mngObj.listOfProd.get(selectedIndex).getProdQnt());
        System.out.println(newProdQnt); }

    //Increase the inventory for each item when a purchase is completed
    //public void cancelOrder(){}

    //Required actions when a button on the digit pad is clicked
    public void btnClicked(View v) {
        //When the client clicks on the "Clear" button
        if (v==clear){
            itemQntTV.setText(qntStr="");
            itemSelectedTV.setText("");
            purchasePrice.setText("");
            System.out.println(itemQntTV.getText().toString());
            /*calcObj.calcOperands.clear();
            System.out.println(calcObj.calcOperands.toString());*/
        }
        //When the client clicks on the digit pad
        else{
            String data = ((Button)v).getText().toString();
            qntStr+=data;
            itemQntTV.setText(qntStr);
            calculateTotal();} }

    //Required actions when the buy button is clicked
    public void buyClicked(View v) {
        if (!((itemQntTV.getText().toString().isEmpty())||(itemSelectedTV.getText().toString().isEmpty()))){
            //int userSelectedQnt = Integer.parseInt(itemQntTV.getText().toString());

            if(!(mngObj.checkInventory(mngObj.listOfProd.get(selectedIndex),userQnt))){
                Toast.makeText(this,"Not enough quantity in stock!!!",Toast.LENGTH_SHORT).show();
                itemQntTV.setText(qntStr="");
                purchasePrice.setText(String.format("$%,.2f", nullTotal));}
            else{
                newProdQnt = mngObj.listOfProd.get(selectedIndex).getProdQnt()-userQnt;
                purchasePrice.setText(String.format("$%,.2f", calculateTotal()));
                updateInventoryQnt();
                showAlertBox();
                customAdapter.notifyDataSetChanged();
                itemQntTV.setText(qntStr="");
                itemSelectedTV.setText("");
                purchasePrice.setText("");
                Log.d("new item qnt", String.valueOf(newProdQnt));
            }}
        else {
            Toast.makeText(this,"All fields are required",Toast.LENGTH_SHORT).show();
        }
    }

    //Shows a dialog box whe the shopper purchases an item
    private void showAlertBox(){
        builder.setTitle("Thank you for shopping with us");
        builder.setMessage("Your purchase is:" + "\n" + userQnt + " "+
                mngObj.listOfProd.get(selectedIndex).getProdName()+ " "+
                "for the total price of "+ String.format("$%,.2f", calculateTotal()));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"OK clicked",Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Cancel clicked",Toast.LENGTH_SHORT).show();
                //Cancel Order
            }
        });
        AlertDialog alertDialog=builder.create();
        builder.show();
    }

    public void mngBtnClicked(View v) {
        Intent toMngActivity = new Intent(this, ManagerActivity.class);
        startActivity(toMngActivity);
    }

}