package com.example.uni.dialog.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.uni.dialog.MyListener.Functions;
import com.example.uni.dialog.MyListener.MyListener;
import com.example.uni.dialog.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListener _listener = MyListener.getInstance(R.id.activity_main, this);

        _listener.addOnClickAction(R.id.button_entry, Functions.button_entry, this);
        _listener.addOnClickAction(R.id.button_edit, Functions.button_edit, this);
        _listener.addOnClickAction(R.id.button_factors, Functions.button_factors, this);
        _listener.addOnClickAction(R.id.button_measure, Functions.button_measure, this);
    }
}
