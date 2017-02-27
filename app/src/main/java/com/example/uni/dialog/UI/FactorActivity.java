package com.example.uni.dialog.UI;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uni.dialog.Database.DataSource;
import com.example.uni.dialog.Database.Objects.Factor;
import com.example.uni.dialog.R;

public class FactorActivity extends AppCompatActivity {

    DataSource _database;
    EditText _morningFactor;
    EditText _middayFactor;
    EditText _eveningFactor;
    EditText _correctionFactor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factors);
        _database = new DataSource(this);

        _database.open();
        //database.setFactor(new Factor(2.0, 2.0, 2.0, 100, 360, 720, 1200));
        // TODO: Get current Factor Values from Database
        Factor currentFactor;
        try {
            currentFactor = _database.getFactor();
        } catch(Exception ex) {
            currentFactor = new Factor(2.0, 2.0, 2.0, 100, 360, 720, 1200);
        }

        _morningFactor = (EditText)findViewById(R.id.editText_morning);
        _middayFactor = (EditText)findViewById(R.id.editText_midday);
        _eveningFactor = (EditText)findViewById(R.id.editText_evening);
        _correctionFactor = (EditText)findViewById(R.id.editText_correction);

        _morningFactor.setText(String.valueOf(currentFactor.getMorningFactor()));
        _middayFactor.setText(String.valueOf(currentFactor.getMiddayFactor()));
        _eveningFactor.setText(String.valueOf(currentFactor.getEveningFactor()));
        _correctionFactor.setText(String.valueOf(currentFactor.getCorrectionFactor()));

        _database.close();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.button_factor_change:

                        new AlertDialog.Builder(FactorActivity.this).setTitle("Änderungen Übernehmen?").setMessage("Die Änderungen an den Faktoren werden gespeichert und für die zukünftige Insulinbedarfsberechnung genutzt.").setPositiveButton("Änderungen Übernehmen", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                _database.open();
                                _database.setFactor(new Factor(Double.parseDouble(_morningFactor.getText().toString()), Double.parseDouble(_middayFactor.getText().toString()), Double.parseDouble(_eveningFactor.getText().toString()), Integer.parseInt(_correctionFactor.getText().toString())));
                                _database.close();
                                Toast.makeText(FactorActivity.this, "Änderungen wurden gespeichert.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }).setNegativeButton("Abrrechen", null).show();
                }
            }
        };

        Button factorButton = (Button)findViewById(R.id.button_factor_change);
        factorButton.setOnClickListener(listener);
    }
}
