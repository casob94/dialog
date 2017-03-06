package com.example.uni.dialog.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uni.dialog.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.button_entry:
                        Intent recordIntent = new Intent(MainActivity.this, RecordActivity.class);
                        startActivity(recordIntent);
                        break;
                    case R.id.button_edit:
                        //Edit Records.
                        Intent recordEditIntent = new Intent(MainActivity.this, RecordEditActivity.class);
                        startActivity(recordEditIntent);
                        break;
                    case R.id.button_measure:
                        //FreeStyle Libre support still to implement.
                        break;
                    case R.id.button_factors:
                        Intent factorIntent = new Intent(MainActivity.this, FactorActivity.class);
                        startActivity(factorIntent);
                }
            }
        };

        Button entryButton = (Button)findViewById(R.id.button_entry);
        entryButton.setOnClickListener(listener);
        Button editButton = (Button)findViewById(R.id.button_edit);
        editButton.setOnClickListener(listener);
        Button measureButton = (Button)findViewById(R.id.button_measure);
        Button factorButton = (Button)findViewById(R.id.button_factors);
        factorButton.setOnClickListener(listener);
    }


}
