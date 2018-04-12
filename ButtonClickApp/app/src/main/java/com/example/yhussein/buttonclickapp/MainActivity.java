package com.example.yhussein.buttonclickapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

//Class that allows backwards compatibility from import statement
public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets which layout to use
        setContentView(R.layout.activity_main);
    }
}
