package com.example.yhussein.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_FILE = "com.example.yhussein.sharedpreferences.preferences";
    private static final String KEY_EDITTEXT = "key_edittext";
    private SharedPreferences.Editor Editor;
    private SharedPreferences SharedPreferences;
    private EditText EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText = findViewById(R.id.editText3);
        SharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        Editor = SharedPreferences.edit();

        String editTextString = SharedPreferences.getString(KEY_EDITTEXT, "");
        EditText.setText(editTextString);


    }

    @Override
    protected void onPause()This {
        super.onPause();

        Editor.putString(KEY_EDITTEXT, EditText.getText().toString());
        Editor.apply();
    }
}
