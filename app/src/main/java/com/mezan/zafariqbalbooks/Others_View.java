package com.mezan.zafariqbalbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Others_View extends AppCompatActivity {

    ListAdapter adapter;
    String[] categoryName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others__view);
        OthersView();
    }
    private void OthersView(){
        ListView main_list = findViewById(R.id.others_list);
        categoryName = getResources().getStringArray(R.array.others);
        adapter = new ListAdapter(categoryName, this);
        main_list.setAdapter(adapter);
        main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent readerIntent = new Intent(Others_View.this,Reader.class);
                readerIntent.putExtra("Activity","OV");
                readerIntent.putExtra("index",i);
                startActivity(readerIntent);
            }
        });

    }
}
