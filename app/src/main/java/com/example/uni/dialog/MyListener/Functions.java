package com.example.uni.dialog.MyListener;

import android.content.Intent;

import com.example.uni.dialog.R;
import com.example.uni.dialog.UI.FactorActivity;
import com.example.uni.dialog.UI.RecordActivity;

public class Functions {

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
            System.out.println("Write Factors in Database");
        }
    };
}
