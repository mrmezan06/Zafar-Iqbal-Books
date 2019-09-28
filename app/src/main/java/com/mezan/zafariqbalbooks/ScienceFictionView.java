package com.mezan.zafariqbalbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ScienceFictionView extends AppCompatActivity {

    ListAdapter adapter;
    String[] categoryName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_fiction_view);
        Science_Fiction_View();
    }
    private void Science_Fiction_View(){
        ListView main_list = findViewById(R.id.science_fiction_list);
        categoryName = getResources().getStringArray(R.array.ScienceFictionList);
        adapter = new ListAdapter(categoryName, this);
        main_list.setAdapter(adapter);
        main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent readerIntent = new Intent(ScienceFictionView.this,Reader.class);
                readerIntent.putExtra("Activity","SFV");
                readerIntent.putExtra("index",i);
                startActivity(readerIntent);
            }
        });

    }
}
