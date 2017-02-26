package com.example.uni.dialog.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.uni.dialog.Database.DataSource;
import com.example.uni.dialog.MyListener.Functions;
import com.example.uni.dialog.MyListener.MyListener;
import com.example.uni.dialog.R;

public class FactorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);

        DataSource database = new DataSource(this);

        database.open();
        // TODO: Get current Factor Values from Database
        database.close();

        MyListener listener = MyListener.getInstance(R.layout.activity_factors, this);

        listener.addOnClickAction(R.id.button_factor_change, Functions.button_factor_change, this);

    }
}
