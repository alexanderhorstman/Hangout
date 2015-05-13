package com.example.alexh.hangout;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateSchedule extends FragmentActivity implements AdapterView.OnItemSelectedListener {

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
    private ListAdapter[] adapter;
    private ListView[] listArray;
    private ActivityList[] activityListArray;
    private ActivityList sunActivityList;
    private ActivityList monActivityList;
    private ActivityList tueActivityList;
    private ActivityList wedActivityList;
    private ActivityList thuActivityList;
    private ActivityList friActivityList;
    private ActivityList satActivityList;
    private ListView sunListView;
    private ListView monListView;
    private ListView tueListView;
    private ListView wedListView;
    private ListView thuListView;
    private ListView friListView;
    private ListView satListView;
    private ListAdapter sunAdapter;
    private ListAdapter monAdapter;
    private ListAdapter tueAdapter;
    private ListAdapter wedAdapter;
    private ListAdapter thuAdapter;
    private ListAdapter friAdapter;
    private ListAdapter satAdapter;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

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
        /*
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CreateScheduleFragment scheduleFragment = new CreateScheduleFragment();
        fragmentTransaction.replace(android.R.id.content, scheduleFragment);
        fragmentTransaction.commit();
        */
        setContentView(R.layout.create_schedule);
        View tempView = findViewById(R.id.create_activity_fragment);
        tempView.setVisibility(View.GONE);
        initializeAll();

        /*
        listArray = new ListView[7];
        listArray[0] = (ListView) findViewById(R.id.sun_list_view);
        listArray[1] = (ListView) findViewById(R.id.mon_list_view);
        listArray[2] = (ListView) findViewById(R.id.tue_list_view);
        listArray[3] = (ListView) findViewById(R.id.wed_list_view);
        listArray[4] = (ListView) findViewById(R.id.thu_list_view);
        listArray[5] = (ListView) findViewById(R.id.fri_list_view);
        listArray[6] = (ListView) findViewById(R.id.sat_list_view);
        activityListArray = new ActivityList[7];
        adapter = new ListAdapter[7];
        for(int i = 0; i < listArray.length; i++) {
            final int index = i;
            activityListArray[i] = new ActivityList();
            adapter[i] = new ListAdapter(this, activityListArray[i].toStringArray(), activityListArray[i]);
            listArray[i].setAdapter(adapter[i]);
            listArray[i].setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //pull up the create activity fragment
                    Toast.makeText(getBaseContext(), activityListArray[index].getActivity(position)
                    .toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        */

        /*
        Spinner dayOfWeekSpinner = (Spinner)  findViewById(R.id.day_of_week_spinner_create_profile);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.days_of_week, android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dayOfWeekSpinner.setAdapter(spinnerAdapter);
        */
    }

    public void addTimeToSchedule(View view) {
        TextView newText = new TextView(getBaseContext());
        //TextView fromTextView = (TextView) findViewById(R.id.from_text_view_create_schedule);
        //TextView toTextView = (TextView) findViewById(R.id.to_text_view_create_schedule);
        /*
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
        */
        //fromTextView.setText("From");
        //toTextView.setText("To");
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

    private void initializeAll() {
        sunActivityList = new ActivityList();
        monActivityList = new ActivityList();
        tueActivityList = new ActivityList();
        wedActivityList = new ActivityList();
        thuActivityList = new ActivityList();
        friActivityList = new ActivityList();
        satActivityList = new ActivityList();
        sunListView = (ListView) findViewById(R.id.sun_list_view);
        monListView = (ListView) findViewById(R.id.mon_list_view);
        tueListView = (ListView) findViewById(R.id.tue_list_view);
        wedListView = (ListView) findViewById(R.id.wed_list_view);
        thuListView = (ListView) findViewById(R.id.thu_list_view);
        friListView = (ListView) findViewById(R.id.fri_list_view);
        satListView = (ListView) findViewById(R.id.sat_list_view);
        sunAdapter = new ListAdapter(this, sunActivityList.toStringArray(), sunActivityList);
        monAdapter = new ListAdapter(this, monActivityList.toStringArray(), monActivityList);
        tueAdapter = new ListAdapter(this, tueActivityList.toStringArray(), tueActivityList);
        wedAdapter = new ListAdapter(this, wedActivityList.toStringArray(), wedActivityList);
        thuAdapter = new ListAdapter(this, thuActivityList.toStringArray(), thuActivityList);
        friAdapter = new ListAdapter(this, friActivityList.toStringArray(), friActivityList);
        satAdapter = new ListAdapter(this, satActivityList.toStringArray(), satActivityList);
        sunListView.setAdapter(sunAdapter);
        monListView.setAdapter(monAdapter);
        tueListView.setAdapter(tueAdapter);
        wedListView.setAdapter(wedAdapter);
        thuListView.setAdapter(thuAdapter);
        friListView.setAdapter(friAdapter);
        satListView.setAdapter(satAdapter);
        sunListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //pull up create activity fragment
                Toast.makeText(getBaseContext(), sunActivityList.getActivity(position)
                        .toString(), Toast.LENGTH_SHORT).show();
                View activityFragmentView = findViewById(R.id.create_activity_fragment);
                if(activityFragmentView.getVisibility() == View.GONE) {
                    activityFragmentView.setVisibility(View.VISIBLE);
                }
                else if(activityFragmentView.getVisibility() == View.VISIBLE) {
                    activityFragmentView.setVisibility(View.GONE);
                }
                TextView dayOfWeekTextView = (TextView) findViewById(R.id.day_of_week_text_view_create_activity_fragment);
                dayOfWeekTextView.setText("Sunday");
            }
        });
        //repeat for each list view when onclick is done
    }
}
