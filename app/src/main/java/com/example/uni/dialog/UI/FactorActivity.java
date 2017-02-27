package com.example.uni.dialog.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.uni.dialog.Database.DataSource;
import com.example.uni.dialog.Database.Objects.Factor;
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
        //database.setFactor(new Factor(2.0, 2.0, 2.0, 100, 360, 720, 1200));
        // TODO: Get current Factor Values from Database
        Factor currentFactor = null;
        try {
            currentFactor = database.getFactor();
        } catch(Exception ex) {
            currentFactor = new Factor(2.0, 2.0, 2.0, 100, 360, 720, 1200);
        }

        EditText morningFactor = (EditText)findViewById(R.id.editText_morning);
        EditText middayFactor = (EditText)findViewById(R.id.editText_midday);
        EditText eveningFactor = (EditText)findViewById(R.id.editText_evening);
        EditText correctionFactor = (EditText)findViewById(R.id.editText_correction);

        morningFactor.setText(String.valueOf(currentFactor.getMorningFactor()));
        middayFactor.setText(String.valueOf(currentFactor.getMiddayFactor()));
        eveningFactor.setText(String.valueOf(currentFactor.getEveningFactor()));
        correctionFactor.setText(String.valueOf(currentFactor.getCorrectionFactor()));

        database.close();

        MyListener listener = MyListener.getInstance(R.layout.activity_factors, this);

        listener.addOnClickAction(R.id.button_factor_change, Functions.button_factor_change, this);

    }
}
