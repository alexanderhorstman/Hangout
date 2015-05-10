package com.example.alexh.hangout;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener{

    private String time;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = 0;

        return new TimePickerDialog(getActivity(), this, hour, minute, false);
    }

    public String getTime() {
        return time;
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(getActivity(), hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
        if(hourOfDay > 12) {
            hourOfDay -= 12;
        }
        else if(hourOfDay ==0) {
            hourOfDay = 12;
        }
        if(minute < 10) {
            time = hourOfDay + ":0" + minute;
        }
        else {
            time = hourOfDay + ":" + minute;
        }
    }
}
