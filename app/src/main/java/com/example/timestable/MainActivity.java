package com.example.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generateTimesTable (int timesTableNumber) {
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j <= 10; j++) {
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = findViewById(R.id.timesTablesSeekBar);
        timesTableListView= findViewById(R.id.ListView);
        int max = 20;
        int startingPosition = 10;

        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(startingPosition);

        generateTimesTable(startingPosition);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timeTableNumber ;
                if (i < min) {
                    timeTableNumber = min;
                    timesTableSeekBar.setProgress(min);
                } else {
                    timeTableNumber = i;
                }
                Log.i("SeekBar Value", Integer.toString(timeTableNumber));

                generateTimesTable(timeTableNumber);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}