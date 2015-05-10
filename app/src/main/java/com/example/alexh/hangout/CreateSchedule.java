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
import android.widget.Toast;

public class CreateSchedule extends Activity implements AdapterView.OnItemSelectedListener {

    static final String[] validTimes = {"12:00 - 12:30", "12:30 - 1:00", "1:00 - 1:30",
            "1:30 - 2:00", "2:00 - 2:30","2:30 - 3:00", "3:00 - 3:30", "3:30 - 4:00",
            "4:00 - 4:30", "4:30 - 5:00","5:00 - 5:30", "5:30 - 6:00", "6:00 - 6:30",
            "6:30 - 7:00", "7:00 - 7:30","7:30 - 8:00", "8:00 - 8:30", "8:30 - 9:00",
            "9:00 - 9:30", "9:30 - 10:00","10:00 - 10:30", "10:30 - 11:00", "11:00 - 11:30",
            "11:30 - 12:00"};
    private boolean[][] freeTime = new boolean[48][7];
    private String dayOfWeek = "Sunday";
    private TimePickerFragment startPickerFragment;
    private TimePickerFragment stopPickerFragment;

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
        TextView fromTextView = (TextView) findViewById(R.id.from_text_view_create_schedule);
        TextView toTextView = (TextView) findViewById(R.id.to_text_view_create_schedule);
        switch (dayOfWeek) {
            case "Sunday":
                newText = (TextView) findViewById(R.id.sunday_text_view_create_schedule);
                break;
            case "Monday":
                newText = (TextView) findViewById(R.id.monday_text_view_create_schedule);
                break;
            case "Tuesday":
                newText = (TextView) findViewById(R.id.tuesday_text_view_create_schedule);
                break;
            case "Wednesday":
                newText = (TextView) findViewById(R.id.wednesday_text_view_create_schedule);
                break;
            case "Thursday":
                newText = (TextView) findViewById(R.id.thursday_text_view_create_schedule);
                break;
            case "Friday":
                newText = (TextView) findViewById(R.id.friday_text_view_create_schedule);
                break;
            case "Saturday":
                newText = (TextView) findViewById(R.id.saturday_text_view_create_schedule);
                break;
        }
        newText.append(startPickerFragment.getTime() + " - " + stopPickerFragment.getTime() + ";  ");
        fromTextView.setText("From");
        toTextView.setText("To");
    }

    public void finishProfile(View view) {

    }

    //method not being called when item is selected
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        dayOfWeek = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), position, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void pickStartTime(View v) {
        startPickerFragment = new TimePickerFragment();
        startPickerFragment.setType("start");
        startPickerFragment.show(getFragmentManager(), "startPicker");
    }

    public void pickStopTime(View v) {
        stopPickerFragment = new TimePickerFragment();
        stopPickerFragment.setType("stop");
        stopPickerFragment.show(getFragmentManager(), "stopPicker");
    }

    public void returnToCreateProfile(View view) {
        //set result code to canceled
        setResult(RESULT_CANCELED);
        //leave this activity
        finish();
    }
}
