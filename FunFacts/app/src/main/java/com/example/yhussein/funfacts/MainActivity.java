package com.example.yhussein.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yhussein.funfacts.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Make variable only available inside this class
    private FactBook factBook = new FactBook();
    // Declare our View variables
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the Views from the layout file to the corresponding variables
        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);
        relativeLayout = findViewById(R.id.)

        // Make button do something set up onclick method
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            // Code to run when button is clicked
            public void onClick(View v) {
                String fact = factBook.getFact();

                // Update screen with new fact - Change layout
                factTextView.setText(fact);
            }
        };
        showFactButton.setOnClickListener(listener);
    }
}


// An activity is a screen that users can interact with
// A field is inside the class but outside of other methods
// Assign views after setcontentview
// R stands for resources