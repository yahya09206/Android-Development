package com.example.yhussein.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yhussein.interactivestory.R;
import com.example.yhussein.interactivestory.model.Page;
import com.example.yhussein.interactivestory.model.Story;

public class StoryAcitivity extends AppCompatActivity {
    public static final String TAG = StoryAcitivity.class.getSimpleName();

    // Fields for variables
    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_acitivity);

        // Init fields with their IDs
        storyImageView = findViewById(R.id.storyImageView);
        storyTextView = findViewById(R.id.storyTextView);
        choice1Button = findViewById(R.id.choice1Button);
        choice2Button = findViewById(R.id.choice2Button);

        // GET INTENT
        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));
        // Set null pointer exception
        if(name == null || name.isEmpty()){
            name = "FRIEND";
        }
        // Log Statement
        Log.d(TAG, name);
        // Init default constructor
        story = new Story();
        // Method for loading page
        loadPage(0);


    }

    private void loadPage(int pageNumber) {
        final Page page = story.getPage(pageNumber);

        // Set the sources for each view
        Drawable image = ContextCompat.getDrawable(this, page.getImageId());
        storyImageView.setImageDrawable(image);

        // String variable to hold text of our story
        String pageText = getString(page.getTextId());
        // Store reformatted text into new variable. Add name if placeholder included. Won't add if not
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);

        if(page.isFinalPage()){
            //Hide one button
            choice1Button.setVisibility(View.INVISIBLE);
            choice2Button.setText(R.string.play_again_button_text);
            choice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Will take back to main activity
                    finish();
                }
            });

        }else {
            loadButtons(page);
        }

    }

    private void loadButtons(final Page page) {
        choice1Button.setText(page.getChoice1().getTextId());
        // Onclick listener for choice1 button
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = page.getChoice1().getNextPage();
                loadPage(nextPage);

            }
        });


        choice2Button.setText(page.getChoice2().getTextId());
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = page.getChoice2().getNextPage();
                loadPage(nextPage);

            }
        });
    }
}
