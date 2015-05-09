package com.example.alexh.hangout;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, false);
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(getActivity(), hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
        //String tag = view.getTag().toString();
        //Toast.makeText(getActivity(), tag, Toast.LENGTH_SHORT).show();
    }
}
