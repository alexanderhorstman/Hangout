package com.example.alexh.hangout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class CreateSchedule extends Activity{

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

    public void pickStartTime(View view) {

    }

    public void pickStopTime(View view) {

    }
}
