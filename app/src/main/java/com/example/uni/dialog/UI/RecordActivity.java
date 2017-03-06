package com.example.uni.dialog.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.uni.dialog.R;

import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
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

                    Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone(Calendar.getInstance().getTimeZone().getDisplayName()));

                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm",Locale.GERMAN);
                    SimpleDateFormat timeFormat = new SimpleDateFormat("dd.MM.yy", Locale.GERMAN);

                    timeEdit.setText(dateFormat.format(calendar.getTime()));
                    dateEdit.setText(timeFormat.format(calendar.getTime()));

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
