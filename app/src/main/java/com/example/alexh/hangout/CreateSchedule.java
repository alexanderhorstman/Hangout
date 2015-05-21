package com.example.alexh.hangout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateSchedule extends FragmentActivity {

    private boolean[][] schedule = new boolean[48][7];
    private TimePickerFragment startPickerFragment;
    private TimePickerFragment stopPickerFragment;
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
    private ViewHolder viewHolder;
    private int indexToBeUpdated = -1;

    @Override
    public void onBackPressed() {
        if(viewHolder.activityView.getVisibility() == View.GONE) {
            //set result code to canceled
            setResult(RESULT_CANCELED);
            //leave this activity
            finish();
        }
        else {
            viewHolder.activityView.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_schedule);
        viewHolder = new ViewHolder();
        viewHolder.activityView.setVisibility(View.GONE);
        initializeAll();
    }

    public void addActivityToSchedule(View view) {
        if(viewHolder.descriptionEditText.getText().toString().equals("")) {
            makeToast("Description cannot be empty.", true);
        }
        else if(viewHolder.startButton.getText().toString().equals("Start Time")) {
            makeToast("Choose a start time.", true);
        }
        else if(viewHolder.stopButton.getText().toString().equals("Stop Time")) {
            makeToast("Choose a stop time.", true);
        }
        else {
            if(viewHolder.addButton.getText().toString().equals("Update")) {
                if(indexToBeUpdated != -1) {
                    switch(viewHolder.dayOfWeekTextView.getText().toString()) {
                        case "Sunday":
                            if(indexToBeUpdated < sunActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                sunActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Sunday");
                            }
                            break;
                        case "Monday":
                            if(indexToBeUpdated < monActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                monActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Monday");
                            }
                            break;
                        case "Tuesday":
                            if(indexToBeUpdated < tueActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                tueActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Tuesday");
                            }
                            break;
                        case "Wednesday":
                            if(indexToBeUpdated < wedActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                wedActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Wednesday");
                            }
                            break;
                        case "Thursday":
                            if(indexToBeUpdated < thuActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                thuActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Thursday");
                            }
                            break;
                        case "Friday":
                            if(indexToBeUpdated < friActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                friActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Friday");
                            }
                            break;
                        case "Saturday":
                            if(indexToBeUpdated < satActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                satActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Saturday");
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            else {
                viewHolder.activityView.setVisibility(View.GONE);
                ScheduleActivity newActivity = new ScheduleActivity(startPickerFragment.getHour(),
                        startPickerFragment.getMinute(), startPickerFragment.getAmPm(),
                        stopPickerFragment.getHour(), stopPickerFragment.getMinute(),
                        stopPickerFragment.getAmPm(),
                        viewHolder.descriptionEditText.getText().toString());
                switch(viewHolder.dayOfWeekTextView.getText().toString()) {
                    case "Sunday":
                        sunActivityList.addActivity(newActivity);
                        updateAdapter("Sunday");
                        break;
                    case "Monday":
                        monActivityList.addActivity(newActivity);
                        updateAdapter("Monday");
                        break;
                    case "Tuesday":
                        tueActivityList.addActivity(newActivity);
                        updateAdapter("Tuesday");
                        break;
                    case "Wednesday":
                        wedActivityList.addActivity(newActivity);
                        updateAdapter("Wednesday");
                        break;
                    case "Thursday":
                        thuActivityList.addActivity(newActivity);
                        updateAdapter("Thursday");
                        break;
                    case "Friday":
                        friActivityList.addActivity(newActivity);
                        updateAdapter("Friday");
                        break;
                    case "Saturday":
                        satActivityList.addActivity(newActivity);
                        updateAdapter("Saturday");
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void cancelNewActivity(View view) {
        viewHolder.activityView.setVisibility(View.GONE);
    }

    public void convertListViewsToSchedule() {

    }

    public void finishProfile(View view) {
        //do stuff to create and save a profile
        convertListViewsToSchedule();
        Intent previousActivity = getIntent();
        Profile newProfile = (Profile) previousActivity.getSerializableExtra("profileInProgress");
        newProfile.setSchedule(schedule);
        //addNewUser();
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
                View activityFragmentView = findViewById(R.id.create_activity_fragment);
                TextView dayOfWeekTextView = (TextView) findViewById(R.id.day_of_week_text_view_create_activity_fragment);
                dayOfWeekTextView.setText("Sunday");
                if(sunActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(sunActivityList.getActivity(position).getDescription());
                    if(sunActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                sunActivityList.getActivity(position).getStartHour() + ":0"
                                        + sunActivityList.getActivity(position).getStartMinute()
                                        + sunActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                sunActivityList.getActivity(position).getStartHour() + ":"
                                        + sunActivityList.getActivity(position).getStartMinute()
                                        + sunActivityList.getActivity(position).getStartAmPm());
                    }
                    if(sunActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                sunActivityList.getActivity(position).getStopHour() + ":0"
                                        + sunActivityList.getActivity(position).getStopMinute()
                                        + sunActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                sunActivityList.getActivity(position).getStopHour() + ":"
                                        + sunActivityList.getActivity(position).getStopMinute()
                                        + sunActivityList.getActivity(position).getStopAmPm());
                    }
                    viewHolder.addButton.setText("Update");
                    indexToBeUpdated = position;
                }
                if(activityFragmentView.getVisibility() == View.GONE) {
                    activityFragmentView.setVisibility(View.VISIBLE);
                }
                else if(activityFragmentView.getVisibility() == View.VISIBLE) {
                    activityFragmentView.setVisibility(View.GONE);
                }
            }
        });
        monListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //pull up create activity fragment
                View activityFragmentView = findViewById(R.id.create_activity_fragment);
                TextView dayOfWeekTextView = (TextView) findViewById(R.id.day_of_week_text_view_create_activity_fragment);
                dayOfWeekTextView.setText("Monday");
                if(monActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(monActivityList.getActivity(position).getDescription());
                    if(monActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                monActivityList.getActivity(position).getStartHour() + ":0"
                                        + monActivityList.getActivity(position).getStartMinute()
                                        + monActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                monActivityList.getActivity(position).getStartHour() + ":"
                                        + monActivityList.getActivity(position).getStartMinute()
                                        + monActivityList.getActivity(position).getStartAmPm());
                    }
                    if(monActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                monActivityList.getActivity(position).getStopHour() + ":0"
                                        + monActivityList.getActivity(position).getStopMinute()
                                        + monActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                monActivityList.getActivity(position).getStopHour() + ":"
                                        + monActivityList.getActivity(position).getStopMinute()
                                        + monActivityList.getActivity(position).getStopAmPm());
                    }
                    viewHolder.addButton.setText("Update");
                    indexToBeUpdated = position;
                }
                if(activityFragmentView.getVisibility() == View.GONE) {
                    activityFragmentView.setVisibility(View.VISIBLE);
                }
                else if(activityFragmentView.getVisibility() == View.VISIBLE) {
                    activityFragmentView.setVisibility(View.GONE);
                }
            }
        });
        tueListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //pull up create activity fragment
                View activityFragmentView = findViewById(R.id.create_activity_fragment);
                TextView dayOfWeekTextView = (TextView) findViewById(R.id.day_of_week_text_view_create_activity_fragment);
                dayOfWeekTextView.setText("Tuesday");
                if(tueActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(tueActivityList.getActivity(position).getDescription());
                    if(tueActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                tueActivityList.getActivity(position).getStartHour() + ":0"
                                        + tueActivityList.getActivity(position).getStartMinute()
                                        + tueActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                tueActivityList.getActivity(position).getStartHour() + ":"
                                        + tueActivityList.getActivity(position).getStartMinute()
                                        + tueActivityList.getActivity(position).getStartAmPm());
                    }
                    if(tueActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                tueActivityList.getActivity(position).getStopHour() + ":0"
                                        + tueActivityList.getActivity(position).getStopMinute()
                                        + tueActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                tueActivityList.getActivity(position).getStopHour() + ":"
                                        + tueActivityList.getActivity(position).getStopMinute()
                                        + tueActivityList.getActivity(position).getStopAmPm());
                    }
                    viewHolder.addButton.setText("Update");
                    indexToBeUpdated = position;
                }
                if(activityFragmentView.getVisibility() == View.GONE) {
                    activityFragmentView.setVisibility(View.VISIBLE);
                }
                else if(activityFragmentView.getVisibility() == View.VISIBLE) {
                    activityFragmentView.setVisibility(View.GONE);
                }
            }
        });
        wedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //pull up create activity fragment
                View activityFragmentView = findViewById(R.id.create_activity_fragment);
                TextView dayOfWeekTextView = (TextView) findViewById(R.id.day_of_week_text_view_create_activity_fragment);
                dayOfWeekTextView.setText("Wednesday");
                if(wedActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(wedActivityList.getActivity(position).getDescription());
                    if(wedActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                wedActivityList.getActivity(position).getStartHour() + ":0"
                                        + wedActivityList.getActivity(position).getStartMinute()
                                        + wedActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                wedActivityList.getActivity(position).getStartHour() + ":"
                                        + wedActivityList.getActivity(position).getStartMinute()
                                        + wedActivityList.getActivity(position).getStartAmPm());
                    }
                    if(wedActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                wedActivityList.getActivity(position).getStopHour() + ":0"
                                        + wedActivityList.getActivity(position).getStopMinute()
                                        + wedActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                wedActivityList.getActivity(position).getStopHour() + ":"
                                        + wedActivityList.getActivity(position).getStopMinute()
                                        + wedActivityList.getActivity(position).getStopAmPm());
                    }
                    viewHolder.addButton.setText("Update");
                    indexToBeUpdated = position;
                }
                if(activityFragmentView.getVisibility() == View.GONE) {
                    activityFragmentView.setVisibility(View.VISIBLE);
                }
                else if(activityFragmentView.getVisibility() == View.VISIBLE) {
                    activityFragmentView.setVisibility(View.GONE);
                }
            }
        });
        thuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //pull up create activity fragment
                View activityFragmentView = findViewById(R.id.create_activity_fragment);
                TextView dayOfWeekTextView = (TextView) findViewById(R.id.day_of_week_text_view_create_activity_fragment);
                dayOfWeekTextView.setText("Thursday");
                if(thuActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(thuActivityList.getActivity(position).getDescription());
                    if(thuActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                thuActivityList.getActivity(position).getStartHour() + ":0"
                                        + thuActivityList.getActivity(position).getStartMinute()
                                        + thuActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                thuActivityList.getActivity(position).getStartHour() + ":"
                                        + thuActivityList.getActivity(position).getStartMinute()
                                        + thuActivityList.getActivity(position).getStartAmPm());
                    }
                    if(thuActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                thuActivityList.getActivity(position).getStopHour() + ":0"
                                        + thuActivityList.getActivity(position).getStopMinute()
                                        + thuActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                thuActivityList.getActivity(position).getStopHour() + ":"
                                        + thuActivityList.getActivity(position).getStopMinute()
                                        + thuActivityList.getActivity(position).getStopAmPm());
                    }
                    viewHolder.addButton.setText("Update");
                    indexToBeUpdated = position;
                }
                if(activityFragmentView.getVisibility() == View.GONE) {
                    activityFragmentView.setVisibility(View.VISIBLE);
                }
                else if(activityFragmentView.getVisibility() == View.VISIBLE) {
                    activityFragmentView.setVisibility(View.GONE);
                }
            }
        });
        friListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //pull up create activity fragment
                View activityFragmentView = findViewById(R.id.create_activity_fragment);
                TextView dayOfWeekTextView = (TextView) findViewById(R.id.day_of_week_text_view_create_activity_fragment);
                dayOfWeekTextView.setText("Friday");
                if(friActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(friActivityList.getActivity(position).getDescription());
                    if(friActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                friActivityList.getActivity(position).getStartHour() + ":0"
                                        + friActivityList.getActivity(position).getStartMinute()
                                        + friActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                friActivityList.getActivity(position).getStartHour() + ":"
                                        + friActivityList.getActivity(position).getStartMinute()
                                        + friActivityList.getActivity(position).getStartAmPm());
                    }
                    if(friActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                friActivityList.getActivity(position).getStopHour() + ":0"
                                        + friActivityList.getActivity(position).getStopMinute()
                                        + friActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                friActivityList.getActivity(position).getStopHour() + ":"
                                        + friActivityList.getActivity(position).getStopMinute()
                                        + friActivityList.getActivity(position).getStopAmPm());
                    }
                    viewHolder.addButton.setText("Update");
                    indexToBeUpdated = position;
                }
                if(activityFragmentView.getVisibility() == View.GONE) {
                    activityFragmentView.setVisibility(View.VISIBLE);
                }
                else if(activityFragmentView.getVisibility() == View.VISIBLE) {
                    activityFragmentView.setVisibility(View.GONE);
                }
            }
        });
        satListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //pull up create activity fragment
                View activityFragmentView = findViewById(R.id.create_activity_fragment);
                TextView dayOfWeekTextView = (TextView) findViewById(R.id.day_of_week_text_view_create_activity_fragment);
                dayOfWeekTextView.setText("Saturday");
                if(satActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(satActivityList.getActivity(position).getDescription());
                    if(satActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                satActivityList.getActivity(position).getStartHour() + ":0"
                                        + satActivityList.getActivity(position).getStartMinute()
                                        + satActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                satActivityList.getActivity(position).getStartHour() + ":"
                                        + satActivityList.getActivity(position).getStartMinute()
                                        + satActivityList.getActivity(position).getStartAmPm());
                    }
                    if(satActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                satActivityList.getActivity(position).getStopHour() + ":0"
                                        + satActivityList.getActivity(position).getStopMinute()
                                        + satActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                satActivityList.getActivity(position).getStopHour() + ":"
                                        + satActivityList.getActivity(position).getStopMinute()
                                        + satActivityList.getActivity(position).getStopAmPm());
                    }
                    viewHolder.addButton.setText("Update");
                    indexToBeUpdated = position;
                }
                if(activityFragmentView.getVisibility() == View.GONE) {
                    activityFragmentView.setVisibility(View.VISIBLE);
                }
                else if(activityFragmentView.getVisibility() == View.VISIBLE) {
                    activityFragmentView.setVisibility(View.GONE);
                }
            }
        });
    }

    public void makeToast(String message, boolean longTime) {
        if(longTime) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateAdapter(String dayOfWeek) {
        switch(dayOfWeek) {
            case "Sunday":
                sunAdapter = new ListAdapter(this, sunActivityList.toStringArray(), sunActivityList);
                sunListView.setAdapter(sunAdapter);
                sunListView.refreshDrawableState();
                break;
            case "Monday":
                monAdapter = new ListAdapter(this, monActivityList.toStringArray(), monActivityList);
                monListView.setAdapter(monAdapter);
                monListView.refreshDrawableState();
                break;
            case "Tuesday":
                tueAdapter = new ListAdapter(this, tueActivityList.toStringArray(), tueActivityList);
                tueListView.setAdapter(tueAdapter);
                tueListView.refreshDrawableState();
                break;
            case "Wednesday":
                wedAdapter = new ListAdapter(this, wedActivityList.toStringArray(), wedActivityList);
                wedListView.setAdapter(wedAdapter);
                wedListView.refreshDrawableState();
                break;
            case "Thursday":
                thuAdapter = new ListAdapter(this, thuActivityList.toStringArray(), thuActivityList);
                thuListView.setAdapter(thuAdapter);
                thuListView.refreshDrawableState();
                break;
            case "Friday":
                friAdapter = new ListAdapter(this, friActivityList.toStringArray(), friActivityList);
                friListView.setAdapter(friAdapter);
                friListView.refreshDrawableState();
                break;
            case "Saturday":
                satAdapter = new ListAdapter(this, satActivityList.toStringArray(), satActivityList);
                satListView.setAdapter(satAdapter);
                satListView.refreshDrawableState();
                break;
            default:
                break;
        }
    }

    private class ViewHolder {
        View activityView = findViewById(R.id.create_activity_fragment);
        TextView dayOfWeekTextView = (TextView) findViewById(R.id.day_of_week_text_view_create_activity_fragment);
        EditText descriptionEditText = (EditText) findViewById(R.id.description_edit_text_create_activity);
        Button startButton = (Button) findViewById(R.id.start_time_button_create_activity_fragment);
        Button stopButton = (Button) findViewById(R.id.stop_time_button_create_activity_fragment);
        Button addButton = (Button) findViewById(R.id.add_button_create_activity_fragment);
    }
}
