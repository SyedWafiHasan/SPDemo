package com.wafihasan.spdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    SharedPreferences sharedPreferences;
    TextView sampleText;
    Snackbar snackbar;
    RelativeLayout relativeLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.relativeLayout);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean b = sharedPreferences.getBoolean("lazy", true);
        sampleText = findViewById(R.id.textView);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        boolean largeText = sharedPreferences.getBoolean("large", false);
        if(largeText)
        {
            sampleText.setTextSize(35);
        }
        else if(!largeText)
        {
            sampleText.setTextSize(25);
        }
        boolean darkTheme = sharedPreferences.getBoolean("dark", false);
        boolean transparent = sharedPreferences.getBoolean("transparent", false);
        if(darkTheme && transparent)
        {
            setTheme(android.R.style.Theme_Holo_Wallpaper);
        }
        String s = sharedPreferences.getString("colour", "#000000");
        try
        {
            sampleText.setTextColor(Color.parseColor(s));
            sampleText.setText(s);
        }
        catch(Exception e)
        {
            snackbar.make(relativeLayout, "Invalid Colour Hex Code", Snackbar.LENGTH_LONG).show();
        }
    }

    public void startSettings(View view)
    {
        startActivity(new Intent(MainActivity.this, PreferenceActivity.class));
    }
}
