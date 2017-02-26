package com.example.uni.dialog.UI;

import android.icu.text.TimeZoneNames;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.uni.dialog.R;

import android.text.format.Time;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        CheckBox setAppendix = (CheckBox) findViewById(R.id.check_appendix);
        setAppendix.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EditText timeEdit = (EditText)findViewById(R.id.editText_time);
                EditText dateEdit = (EditText)findViewById(R.id.editText_date);
                TextView timeText = (TextView)findViewById(R.id.textView_time);
                TextView dateText = (TextView)findViewById(R.id.textView_date);

                if(isChecked) {
                    timeEdit.setVisibility(View.VISIBLE);
                    dateEdit.setVisibility(View.VISIBLE);
                    dateText.setVisibility(View.VISIBLE);
                    timeText.setVisibility(View.VISIBLE);

                    Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone(Time.getCurrentTimezone()));

                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                    SimpleDateFormat timeFormat = new SimpleDateFormat("dd.MM.yy");

                    timeEdit.setText(dateFormat.format(calendar.getTime()).toString());
                    dateEdit.setText(timeFormat.format(calendar.getTime()).toString());

                } else {
                    timeEdit.setVisibility(View.INVISIBLE);
                    dateEdit.setVisibility(View.INVISIBLE);
                    dateText.setVisibility(View.INVISIBLE);
                    timeText.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
