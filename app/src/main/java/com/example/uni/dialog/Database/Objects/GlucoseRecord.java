package com.example.uni.dialog.Database.Objects;

import com.example.uni.dialog.Database.Objects.Factor;

import java.util.Calendar;

public class GlucoseRecord {

    private int _glucoseValue;
    private double _carbonhydrate;
    private double _insulin;
    private Calendar _date;

    public GlucoseRecord(int glucoseValue, double carbonhydrate, double insulin, Calendar date) {
        _glucoseValue = glucoseValue;
        _carbonhydrate = carbonhydrate;
        _insulin = insulin;
        _date = date;
    }

    public GlucoseRecord(int glucoseValue, double carbonhydrate, Calendar date) {
        _glucoseValue = glucoseValue;
        _carbonhydrate = carbonhydrate;
        _date = date;

        //Test Factor TODO: Read Factor from Database
        Factor factor = new Factor(2.5d,1.5d,2d, 100, 360, 720, 1200);

        _insulin = calculateInsulin(carbonhydrate, glucoseValue, factor);
    }

    private int calculateInsulin(double carbonhydrate, double glucoseValue, Factor factor) {
        double insulin = carbonhydrate * factor.getCurrentFactor();
        double glucoseToCorrect = glucoseValue - 100;
        insulin += Math.floor(glucoseToCorrect / factor.getCorrectionFactor());
        return (int)insulin;
    }

    public int getGlucoseValue() {
        return _glucoseValue;
    }

    public double getCarbonhydrate() {
        return _carbonhydrate;
    }

    public double getInsulin() {
        return _insulin;
    }

    public Calendar getDate() {
        return _date;
    }

}
