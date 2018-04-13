package com.example.yhussein.buttonclickapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Class that allows backwards compatibility from import statement
public class MainActivity extends AppCompatActivity {
    //type of objects to be dealing with
    private EditText userInput;
    private Button button;
    private TextView textView;
    private int numTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets which layout to use
        setContentView(R.layout.activity_main);

        //associate fields with the layout. findviewbyid returns the view object based on which id provided.
        userInput = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById((R.id.textView));
        //clear text from design
        textView.setText("");
        textView.setMovementMethod(new ScrollingMovementMethod());
        //New object of type onclicklistener
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //how many times button is clicked and increase it by 1
                numTimesClicked = numTimesClicked + 1;
                //add text to our textview widget
                String result = "\nThe button got tapped " + numTimesClicked + " time";
                //add 's' to end of the word 'time' if button is clicked more than once
                if (numTimesClicked != 1){
                    result += "s";
                }
                //append results to textview
                textView.append(result);
            }
        };
        //telling button to use our onclicklistener method
        button.setOnClickListener(ourOnClickListener);
    }
}
