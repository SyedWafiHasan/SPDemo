package com.wafihasan.spdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    SharedPreferences sharedPreferences;
    TextView sampleText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean b = sharedPreferences.getBoolean("lazy", true);
        sampleText = findViewById(R.id.textView);
        String s = sharedPreferences.getString("colour", "#000000");
        sampleText.setTextColor(Color.parseColor(s));

    }

    public void startSettings(View view)
    {
        startActivity(new Intent(MainActivity.this, PreferenceActivity.class));
    }
    public void setColor(View view)
    {
        String s = sharedPreferences.getString("colour", "#000000");
        setColor(s);
    }
    public void setColor(String s)
    {
        sampleText.setTextColor(Color.parseColor(s));
    }
}
