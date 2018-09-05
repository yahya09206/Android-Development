package com.example.yhussein.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        String name = intent.getStringExtra(getString(R.string.key_name));
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
        Page page = story.getPage(pageNumber);
    }
}
