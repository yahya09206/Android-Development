package com.example.yhussein.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yhussein.interactivestory.R;
import com.example.yhussein.interactivestory.model.Page;

public class StoryAcitivity extends AppCompatActivity {
    public static final String TAG = StoryAcitivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_acitivity);

        // GET INTENT
        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        // Set null pointer exception
        if(name == null || name.isEmpty()){
            name = "FRIEND";
        }
        // Log Statement
        Log.d(TAG, name);


    }
}
