package com.example.uni.dialog.MyListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.widget.EditText;

import com.example.uni.dialog.Database.DataSource;
import com.example.uni.dialog.Database.Objects.Factor;
import com.example.uni.dialog.R;
import com.example.uni.dialog.UI.FactorActivity;
import com.example.uni.dialog.UI.RecordActivity;

public class Functions {

    // TODO: Put them back to their Activity. When finished => Delete MyListener completely.

    public static final Runnable button_entry = new Runnable() {
        @Override
        public void run() {
            Intent recordIntent = new Intent(MyListener._activities.get(R.id.activity_main), RecordActivity.class);
            MyListener._activities.get(R.id.activity_main).startActivity(recordIntent);
        }
    };

    public static final Runnable button_measure = new Runnable() {
        @Override
        public void run() {
            //FreeStyle Libre support still to implement.
        }
    };

    public static final Runnable button_edit = new Runnable() {
        @Override
        public void run() {
            //Editing existing records.
        }
    };

    public static final Runnable button_factors = new Runnable() {
        @Override
        public void run() {
            //Define Userspecific factors.
            Intent recordIntent = new Intent(MyListener._activities.get(R.id.activity_main), FactorActivity.class);
            MyListener._activities.get(R.id.activity_main).startActivity(recordIntent);
        }
    };

    public static final Runnable button_factor_change = new Runnable () {
        @Override
        public void run() {
            // TODO: Write Factors in Database.
            Activity activity = MyListener._activities.get(R.layout.activity_factors);
            DataSource database = new DataSource(activity);

            EditText morningFactor = (EditText)activity.findViewById(R.id.editText_morning);
            EditText middayFactor = (EditText)activity.findViewById(R.id.editText_midday);
            EditText eveningFactor = (EditText)activity.findViewById(R.id.editText_evening);
            EditText correctionFactor = (EditText)activity.findViewById(R.id.editText_correction);

            database.open();
            database.setFactor(new Factor(Double.parseDouble(morningFactor.getText().toString()), Double.parseDouble(middayFactor.getText().toString()), Double.parseDouble(eveningFactor.getText().toString()), Integer.parseInt(correctionFactor.getText().toString())));
            database.close();


            new AlertDialog.Builder(activity).setMessage("Faktoren erfolgreich geändert.").create().show();
            System.out.println("Write Factors in Database");
        }
    };
}
