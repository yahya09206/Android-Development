package com.example.yhussein.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.yhussein.funfacts.R;

public class MainActivity extends AppCompatActivity {
    // Declare our View variables
    private TextView factTextView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


// An activity is a screen that users can interact with
// A field is inside the class but outside of other methods