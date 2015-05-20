package com.example.alexh.hangout;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener{

    private int hour;
    private int minute;
    private String amPm = " am";
    private String time;
    private String type;
    private ScheduleActivity activity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = 0;

        return new TimePickerDialog(getActivity(), this, hour, minute, false);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getAmPm() {
        return amPm;
    }

    public String getTime() {
        return time;
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.minute = minute;
        boolean isAm = true;
        Button fromButton = (Button) getActivity().findViewById(R.id.start_time_button_create_activity_fragment);
        Button toButton = (Button) getActivity().findViewById(R.id.stop_time_button_create_activity_fragment);
        if(hourOfDay > 11) {
            isAm = false;
            amPm = " pm";
        }
        if(hourOfDay > 12) {
            hourOfDay -= 12;
            hour = hourOfDay;
        }
        else if(hourOfDay ==0) {
            hourOfDay = 12;
            hour = hourOfDay;
        }
        hour = hourOfDay;
        if(minute < 10) {
            time = hourOfDay + ":0" + minute;
        }
        else {
            time = hourOfDay + ":" + minute;
        }
        if(type.equals("start")) {
            fromButton.setText(time);
            if(isAm) {
                fromButton.append(" am");
            }
            else {
                fromButton.append(" pm");
            }
        }
        else if(type.equals("stop")) {
            toButton.setText(time);
            if(isAm) {
                toButton.append(" am");
            }
            else {
                toButton.append(" pm");
            }
        }
    }

    public void setType(String type) {
        this.type = type;
    }
}
