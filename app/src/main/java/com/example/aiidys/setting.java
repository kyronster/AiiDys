package com.example.aiidys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class setting extends AppCompatActivity{
        private Spinner fontSpinner;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_setting);

            fontSpinner = findViewById(R.id.fontSpinner);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this,
                    R.array.font_names,  // Create an array resource in res/values/arrays.xml
                    android.R.layout.simple_spinner_item
            );

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            fontSpinner.setAdapter(adapter);

            fontSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    // Get the selected font from the spinner and save it in FontManager
                    String selectedFont = parentView.getItemAtPosition(position).toString();
                    FontManager.setSelectedFont(selectedFont);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // Do nothing
                }
            });
        }
    }

