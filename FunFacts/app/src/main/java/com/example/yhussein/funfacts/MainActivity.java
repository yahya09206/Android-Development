package com.example.yhussein.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yhussein.funfacts.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Declare our View variables
    private TextView factTextView;
    private Button showFactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the Views from the layout file to the corresponding variables
        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);

        // Make button do something set up onclick method
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            // Code to run when button is clicked
            public void onClick(View v) {
                // Make an array of strings
                String[] facts = {
                        "Ants stretch when they wake up in the morning.",
                        "Ostriches can run faster than horses.",
                        "Olympic gold medals are actually made mostly of silver.",
                        "You are born with 300 bones; by the time you are an adult you will have 206.",
                        "It takes about 8 minutes for light from the Sun to reach Earth.",
                        "Some bamboo plants can grow almost a meter in just one day.",
                        "The state of Florida is bigger than England.",
                        "Some penguins can leap 2-3 meters out of the water.",
                        "On average, it takes 66 days to form a new habit.",
                        "Mammoths still walked the earth when the Great Pyramid was being built." };


                // The button was clicked so update the fact TextView with a new fact
                // Randomly select a fact
                Random randomGenerator = new Random();
                // Generate random number
                int randomNumber = randomGenerator.nextInt(10);
                String fact = randomNumber + "";

                // Update screen with new fact
                // Change layout
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