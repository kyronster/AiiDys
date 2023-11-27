package com.example.aiidys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class homescree extends AppCompatActivity{

    ImageButton setting;
    private SharedPreferences sharedPreferences;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescree);
        setting = (ImageButton) findViewById(R.id.settings);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(FontManager.getSelectedFont())
                .setFontAttrId(R.attr.fontPath)
                .build());




        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homescree.this, setting.class);
                startActivity(intent);
            }

        });

    }


}

