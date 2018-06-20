package com.example.terrorizer.teopiotrpromitheuths;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button newOrder;
    Button pelatis;
    Button simerinesParaggelies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        newOrder = (Button)findViewById(R.id.newOrder);  //edw kanw to button na fortwnei allo activity
        newOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrder();
            }
        });

        pelatis = (Button)findViewById(R.id.newPelatis);  //edw kanw to button na fortwnei allo activity
        pelatis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPelatis();
            }
        });

        simerinesParaggelies= (Button) findViewById(R.id.ordersToday);
        simerinesParaggelies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSimerinesParaggelies();
            }
        });

        Date date = new Date();
        Locale locale = new Locale("el", "GR");
        String dateprint = new SimpleDateFormat("EEEE dd-MM-yyy",locale).format(date);
        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(dateprint);
    }

    public void openOrder(){  //kaleitai mesw toy onClickListener
        Intent order = new Intent(MainActivity.this , NewOrder.class);
        startActivity(order);
    }

    public void openPelatis(){  //kaleitai mesw toy onClickListener
        Intent pelatis = new Intent(MainActivity.this , Pelatis.class);
        startActivity(pelatis);
    }

    public void openSimerinesParaggelies(){  //kaleitai mesw toy onClickListener
        Intent pelatis = new Intent(MainActivity.this , simerinesParaggelies.class);
        startActivity(pelatis);
    }

}
