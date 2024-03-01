package com.example.androidsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidsampleapp.Features.AddRecordAPIActivity;
import com.example.androidsampleapp.Features.AddRecordActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void addRecordOnClick(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, AddRecordActivity.class);
        startActivityForResult(intent, 1);
        finish();
    }
    public void addRecordOnClickAPI(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, AddRecordAPIActivity.class);
        startActivityForResult(intent, 2);
        finish();
    }
}