package com.akodiakson.magictavern.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.akodiakson.magictavern.R;
import com.akodiakson.magictavern.util.ActivityUtils;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), EpisodesFragment.newInstance(), R.id.main_fragment_frame);
    }
}
