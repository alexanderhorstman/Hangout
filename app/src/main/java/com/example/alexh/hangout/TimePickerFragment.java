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
    private String type;

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
        boolean isAm = true;
        TextView fromTextView = (TextView) getActivity().findViewById(R.id.from_text_view_create_schedule);
        TextView toTextView = (TextView) getActivity().findViewById(R.id.to_text_view_create_schedule);
        if(hourOfDay > 11) {
            isAm = false;
        }
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
        if(type.equals("start")) {
            fromTextView.setText(time);
            if(isAm) {
                fromTextView.append(" am");
            }
            else {
                fromTextView.append(" pm");
            }
        }
        else if(type.equals("stop")) {
            toTextView.setText(time);
            if(isAm) {
                toTextView.append(" am");
            }
            else {
                toTextView.append(" pm");
            }
        }
    }

    public void setType(String type) {
        this.type = type;
    }
}
