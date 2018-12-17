package com.example.yhussein.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yhussein.funfacts.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Common practice
    public static final String TAG = MainActivity.class.getSimpleName();
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    // Make variable only available inside this class
    private FactBook factBook = new FactBook();
    private ColorWheel colorWheel = new ColorWheel();
    // Declare our View variables
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;
    private String Fact = factBook.facts[0];
    private int Colors = Color.parseColor(colorWheel.colors[8]);

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //put string method to type our fact
        outState.putString(KEY_FACT, Fact);
        outState.putInt(KEY_COLOR, Colors);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Fact = savedInstanceState.getString(KEY_FACT);
        factTextView.setText(Fact);
        Colors = savedInstanceState.getInt(KEY_COLOR);
        relativeLayout.setBackgroundColor(Colors);
        showFactButton.setTextColor(Colors);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the Views from the layout file to the corresponding variables
        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);
        relativeLayout = findViewById(R.id.relativeLayout);

        // Make button do something set up onclick method
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            // Code to run when button is clicked
            public void onClick(View v) {
                Fact = factBook.getFact();

                // Update screen with new fact - Change layout
                factTextView.setText(Fact);

                Colors = colorWheel.getColor();
                relativeLayout.setBackgroundColor(Colors);

                // Match button with BG color
                showFactButton.setTextColor(Colors);
            }
        };
        showFactButton.setOnClickListener(listener);
        // Toast.makeText(this, "Yay! Our Activity was created!", Toast.LENGTH_SHORT).show();

        //LOG MESSAGE
        Log.d(TAG, "We're logging from the onCreate() method!");
    }
}


// An activity is a screen that users can interact with
// A field is inside the class but outside of other methods
// Assign views after setcontentview
// R stands for resources
// Toast is a message that pops up a for little bit informing the user that their input is required