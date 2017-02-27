package com.example.uni.dialog.MyListener;


import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.uni.dialog.R;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MyListener implements View.OnClickListener {

    // Doesn't Work poperly, back to the roots...

    private static MyListener _instance = null;
    private HashMap<Integer, Runnable> _actions;
    private String LOG_TAG = this.getClass().getSimpleName();
    static Stack<Object> _results;
    static HashMap<Integer, Activity> _activities;

    public static MyListener getInstance(Integer Id, Activity context) {
        if(_instance != null) {
            if(!_activities.containsKey(Id)) {
                _activities.put(Id, context);
            }
            return _instance;
        }
        _instance = new MyListener();
        _activities.put(Id, context);
        return _instance;
    }

    private MyListener() {
        _actions = new HashMap<>();
        _results = new Stack<>();
        _activities = new HashMap<>();
    }

    @Override
    public void onClick(View v) {
        try {
            _actions.get(v.getId()).run();
        } catch(Exception ex) {
            Log.e(LOG_TAG, "Execution of Button Action from View:\"" +
                    v.getContext().getResources().getResourceEntryName(v.getId()) + "\" failed." + "\n" + ex.getMessage());
        }
    }

    public void addOnClickAction(Button trigger, Runnable action) {
        _actions.put(trigger.getId(), action);
        trigger.setOnClickListener(this);
    }

    public void addOnClickAction(int id, Runnable action, Activity context) {
        _actions.put(id, action);
        Button but = (Button)context.findViewById(id);
        but.setOnClickListener(this);
    }

    public Object getResult() {
        if(!_results.isEmpty()) {
            return _results.pop();
        }
        return null;
    }

}
