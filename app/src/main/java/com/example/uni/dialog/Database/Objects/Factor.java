package com.example.uni.dialog.Database.Objects;

import android.text.format.Time;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Factor {

    //TODO: Create intent to set morning, midday and evening time.

    private double _morningFactor;
    private double _middayFactor;
    private double _eveningFactor;
    private int _correctionFactor;
    private int _morningTimeMinutes;
    private int _middayTimeMinutes;
    private int _eveningTimeMinutes;


    public Factor(double morningFactor, double middayFactor, double eveningFactor, int correctionFactor, int morningTimeMinutes, int middayTimeMinutes, int eveningTimeMinutes) {
        _morningFactor = morningFactor;
        _middayFactor = middayFactor;
        _eveningFactor = eveningFactor;
        _correctionFactor = correctionFactor;
        _morningTimeMinutes = morningTimeMinutes;
        _middayTimeMinutes = middayTimeMinutes;
        _eveningTimeMinutes = eveningTimeMinutes;
    }

    public Factor(double morningFactor, double middayFactor, double eveningFactor, int correctionFactor) {
        this(morningFactor, middayFactor, eveningFactor, correctionFactor, 360, 720, 1200);
    }

    public double getCurrentFactor() {
        Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone(Calendar.getInstance().getTimeZone().getDisplayName()));

        int currentTimeMinutes = calendar.get(Calendar.HOUR_OF_DAY)*60 + calendar.get(Calendar.MINUTE);

        double currentFactor = -1;

        if(currentTimeMinutes > _morningTimeMinutes) {
            //currentTimeMinutes is later --> probably morning
            currentFactor = _morningFactor;
        }
        if(currentTimeMinutes > _middayTimeMinutes) {
            //currentTimeMinutes is later --> probably midday
            currentFactor = _middayFactor;
        }
        if (currentTimeMinutes > _eveningTimeMinutes){
            //currentTimeMinutes is later --> probably evening
            currentFactor = _eveningFactor;
        }
        return currentFactor;
    }

    public double getMorningFactor() {
        return _morningFactor;
    }

    public double getMiddayFactor() {
        return _middayFactor;
    }

    public double getEveningFactor() {
        return _eveningFactor;
    }

    public int getCorrectionFactor() {
        return _correctionFactor;
    }

    public int getMorningTimeMinutes() {
        return _morningTimeMinutes;
    }

    public int getMiddayTimeMinutes() {
        return _middayTimeMinutes;
    }

    public int getEveningTimeMinutes() {
        return _eveningTimeMinutes;
    }



}
