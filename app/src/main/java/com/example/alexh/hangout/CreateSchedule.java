package com.example.alexh.hangout;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateSchedule extends Activity implements AdapterView.OnItemSelectedListener{

    static final String[] validTimes = {"12:00 - 12:30", "12:30 - 1:00", "1:00 - 1:30",
            "1:30 - 2:00", "2:00 - 2:30","2:30 - 3:00", "3:00 - 3:30", "3:30 - 4:00",
            "4:00 - 4:30", "4:30 - 5:00","5:00 - 5:30", "5:30 - 6:00", "6:00 - 6:30",
            "6:30 - 7:00", "7:00 - 7:30","7:30 - 8:00", "8:00 - 8:30", "8:30 - 9:00",
            "9:00 - 9:30", "9:30 - 10:00","10:00 - 10:30", "10:30 - 11:00", "11:00 - 11:30",
            "11:30 - 12:00"};
    private boolean[][] freeTime = new boolean[48][7];
    private int dayOfWeek;

    @Override
    public void onBackPressed() {
        //set result code to canceled
        setResult(RESULT_CANCELED);
        //leave this activity
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_schedule);
        Spinner dayOfWeekSpinner = (Spinner)  findViewById(R.id.day_of_week_spinner_create_profile);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.days_of_week, android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dayOfWeekSpinner.setAdapter(spinnerAdapter);
    }

    public void addTimeToSchedule(View view) {
        TextView newText = new TextView(getBaseContext());
        Button startButton = (Button) findViewById(R.id.start_time_button_create_schedule);
        Button stopButton = (Button) findViewById(R.id.stop_time_button_create_schedule);
        switch (dayOfWeek) {
            case 0:
                newText = (TextView) findViewById(R.id.sunday_text_view_create_schedule);
                break;
            case 1:
                newText = (TextView) findViewById(R.id.monday_text_view_create_schedule);
                break;
            case 2:
                newText = (TextView) findViewById(R.id.tuesday_text_view_create_schedule);
                break;
            case 3:
                newText = (TextView) findViewById(R.id.wednesday_text_view_create_schedule);
                break;
            case 4:
                newText = (TextView) findViewById(R.id.thursday_text_view_create_schedule);
                break;
            case 5:
                newText = (TextView) findViewById(R.id.friday_text_view_create_schedule);
                break;
            case 6:
                newText = (TextView) findViewById(R.id.saturday_text_view_create_schedule);
                break;
        }
        newText.append(startButton.getText().toString() + " - " + stopButton.getText().toString() + ";");
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        dayOfWeek = position;
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void pickStartTime(View v) {
        DialogFragment pickerFragment = new TimePickerFragment();
        pickerFragment.show(getFragmentManager(), "startPicker");
    }

    public void pickStopTime(View v) {
        DialogFragment pickerFragment = new TimePickerFragment();
        pickerFragment.show(getFragmentManager(), "stopPicker");
    }

    public void returnToCreateProfile(View view) {
        //set result code to canceled
        setResult(RESULT_CANCELED);
        //leave this activity
        finish();
    }
}
