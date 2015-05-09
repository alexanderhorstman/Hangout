package com.example.alexh.hangout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class CreateSchedule extends Activity {

    //24 x 7 array
    static final String[] validTimes = new String[]{
            "12:00 - 12:30", "12:30 - 1:00", "1:00 - 1:30", "1:30 - 2:00", "2:00 - 2:30",
                    "2:30 - 3:00", "3:00 - 3:30", "3:30 - 4:00", "4:00 - 4:30", "4:30 - 5:00",
                    "5:00 - 5:30", "5:30 - 6:00", "6:00 - 6:30", "6:30 - 7:00", "7:00 - 7:30",
                    "7:30 - 8:00", "8:00 - 8:30", "8:30 - 9:00", "9:00 - 9:30", "9:30 - 10:00",
                    "10:00 - 10:30", "10:30 - 11:00", "11:00 - 11:30", "11:30 - 12:00"};
    private boolean[][] freeTime = new boolean[48][7];

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

    }

    public void returnToCreateProfile(View view) {
        //set result code to canceled
        setResult(RESULT_CANCELED);
        //leave this activity
        finish();
    }
}
