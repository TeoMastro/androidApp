package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class orderbydate extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    TextView result;
    TextView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderbydate);
        result = (TextView) findViewById(R.id.fill11);
        header = (TextView) findViewById(R.id.TitleHeaderTODAY);

        ArrayList<String> my_array;
        my_array = getTableValues();

        if(my_array.size() != 0) {
            for (int i = 0; i < my_array.size(); i++) {
                result.append(my_array.get(i));
                result.append("\n");
            }
        }
    }

    public ArrayList<String> getTableValues() {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        ArrayList<String> my_array = new ArrayList<String>();
        Intent intent = getIntent();
        String date = "";
        if(intent != null) {
            date = intent.getStringExtra("date");
        }
        header.setText("Παραγγελίες " +date);
        String temp = dbHandler.loadOrderByDate(date).toString();
        if(!temp.isEmpty()) {
            String qusChoice = temp.substring(0, temp.length() - 1);
            String[] arrayList = qusChoice.split("/");
            for (int i = 0; i < arrayList.length; i++) {

                my_array.add(arrayList[i]);
            }
        } else {
            my_array.add("Δεν υπάρχουν παραγγελίες");
        }
        return my_array;
    }
}