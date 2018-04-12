package com.example.yhussein.buttonclickapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Class that allows backwards compatibility from import statement
public class MainActivity extends AppCompatActivity {
    //type of objects to be dealing with
    private EditText userInput;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets which layout to use
        setContentView(R.layout.activity_main);

        //associate fields with the layout. findviewbyid returns the view object based on which id provided.
        userInput = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById((R.id.textView));
    }
}
