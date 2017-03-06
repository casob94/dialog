package com.example.uni.dialog.UI;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.uni.dialog.Database.DataSource;
import com.example.uni.dialog.R;

/**
 * Created by uni on 27.02.17.
 */

public class RecordEditActivity extends AppCompatActivity {

    private DataSource _database;
    View.OnClickListener _listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_records);

        //Calculate Size from Buttons
        DisplayMetrics screenMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(screenMetrics);

        int width = screenMetrics.widthPixels;
        int height = screenMetrics.heightPixels;
        ImageButton lastDayButton = (ImageButton)findViewById(R.id.button_last_day);
        lastDayButton.setMinimumWidth(width / 4);
        lastDayButton.setMinimumHeight(height / 12);
        lastDayButton.setMaxWidth(width / 4);
        lastDayButton.setMaxHeight(height / 12);
        ImageButton nextDayButton = (ImageButton)findViewById(R.id.button_next_day);
        nextDayButton.setMinimumWidth(width / 4);
        nextDayButton.setMinimumHeight(height / 12);
        nextDayButton.setMaxWidth(width / 4);
        nextDayButton.setMaxHeight(height / 12);
        Button calendarButton = (Button)findViewById(R.id.button_calendar);
        calendarButton.setWidth(width / 2);
        calendarButton.setHeight(height / 12);

        _database = new DataSource(this);


        _listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.button_calendar:
                        System.out.println("Pressed!");
                        break;
                    case R.id.testbutton:
                        System.out.println("Pressed! Test!");
                        break;
                }
            }
        };

        calendarButton.setOnClickListener(_listener);
        Button testbutton = (Button)findViewById(R.id.testbutton);
        testbutton.setOnClickListener(_listener);


    }

}
