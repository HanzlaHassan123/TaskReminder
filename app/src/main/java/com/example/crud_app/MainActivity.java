package com.example.crud_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> surahList= new ArrayList<>();
    ListView surahlist;
    EditText ET_surah;
    Button addSurahBtn;
    Button deleteSurahBtn;
    Button updateSurahBtn;
    int position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surahlist=findViewById(R.id.surahList);
        deleteSurahBtn=findViewById(R.id.deleteSurahBtn);
        updateSurahBtn=findViewById(R.id.updateSurahBtn);
       surahList.add(" I need to do assignment tonight");
       surahList.add("today is the last day of our MobileAndroid assignement submission");
       surahList.add("I promised to meet ahmad today");
       surahList.add("I have to go for a walk");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,surahList);
        surahlist.setAdapter(arrayAdapter);

        addSurahBtn=findViewById(R.id.addSurah);
        ET_surah=findViewById(R.id.ET_surah);
        Collections.sort(surahList);

        addSurahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surahList.add(ET_surah.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        surahlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ET_surah.setText(surahList.get(i));
                position=i;

            }
        });

      deleteSurahBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              surahList.remove(position);
              arrayAdapter.notifyDataSetChanged();
          }
      });

      updateSurahBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              // here implement update functionalities
              surahList.set(position,ET_surah.getText().toString());
              arrayAdapter.notifyDataSetChanged();
          }
      });


    }
}