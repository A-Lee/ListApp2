package com.example.ali.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String [] items;
    String[] prices;
    String[] desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        items = resources.getStringArray(R.array.items);
        prices = resources.getStringArray(R.array.prices);
        desc = resources.getStringArray(R.array.descriptions);

        String output = "";
        for(int i = 0; i < prices.length;i++)
        {
            output+= prices[i] + "\n";
        }
        Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();

        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), items,prices,desc);
        myListView.setAdapter(itemAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(getApplicationContext(), detailActivity.class);
                intent.putExtra("com.example.ali.listapp.itemIndex", position);
                startActivity(intent);
            }
        });

    }
}
