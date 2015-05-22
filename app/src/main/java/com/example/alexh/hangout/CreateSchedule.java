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

    private TimePickerFragment startPickerFragment;
    private TimePickerFragment stopPickerFragment;
    private Schedule newSchedule;
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
                            if(indexToBeUpdated < newSchedule.sunActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                newSchedule.sunActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Sunday");
                            }
                            break;
                        case "Monday":
                            if(indexToBeUpdated < newSchedule.monActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                newSchedule.monActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Monday");
                            }
                            break;
                        case "Tuesday":
                            if(indexToBeUpdated < newSchedule.tueActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                newSchedule.tueActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Tuesday");
                            }
                            break;
                        case "Wednesday":
                            if(indexToBeUpdated < newSchedule.wedActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                newSchedule.wedActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Wednesday");
                            }
                            break;
                        case "Thursday":
                            if(indexToBeUpdated < newSchedule.thuActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                newSchedule.thuActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Thursday");
                            }
                            break;
                        case "Friday":
                            if(indexToBeUpdated < newSchedule.friActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                newSchedule.friActivityList.replace(indexToBeUpdated, newActivity);
                                updateAdapter("Friday");
                            }
                            break;
                        case "Saturday":
                            if(indexToBeUpdated < newSchedule.satActivityList.getSize()) {
                                viewHolder.activityView.setVisibility(View.GONE);
                                ScheduleActivity newActivity =
                                        new ScheduleActivity(startPickerFragment.getHour(),
                                                startPickerFragment.getMinute(),
                                                startPickerFragment.getAmPm(),
                                                stopPickerFragment.getHour(),
                                                stopPickerFragment.getMinute(),
                                                stopPickerFragment.getAmPm(),
                                                viewHolder.descriptionEditText.getText().toString());
                                newSchedule.satActivityList.replace(indexToBeUpdated, newActivity);
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
                        newSchedule.sunActivityList.addActivity(newActivity);
                        updateAdapter("Sunday");
                        break;
                    case "Monday":
                        newSchedule.monActivityList.addActivity(newActivity);
                        updateAdapter("Monday");
                        break;
                    case "Tuesday":
                        newSchedule.tueActivityList.addActivity(newActivity);
                        updateAdapter("Tuesday");
                        break;
                    case "Wednesday":
                        newSchedule.wedActivityList.addActivity(newActivity);
                        updateAdapter("Wednesday");
                        break;
                    case "Thursday":
                        newSchedule.thuActivityList.addActivity(newActivity);
                        updateAdapter("Thursday");
                        break;
                    case "Friday":
                        newSchedule.friActivityList.addActivity(newActivity);
                        updateAdapter("Friday");
                        break;
                    case "Saturday":
                        newSchedule.satActivityList.addActivity(newActivity);
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
        newProfile.setSchedule(newSchedule);
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
        newSchedule = new Schedule();
        newSchedule.sunActivityList = new ActivityList();
        newSchedule.monActivityList = new ActivityList();
        newSchedule.tueActivityList = new ActivityList();
        newSchedule.wedActivityList = new ActivityList();
        newSchedule.thuActivityList = new ActivityList();
        newSchedule.friActivityList = new ActivityList();
        newSchedule.satActivityList = new ActivityList();
        sunListView = (ListView) findViewById(R.id.sun_list_view);
        monListView = (ListView) findViewById(R.id.mon_list_view);
        tueListView = (ListView) findViewById(R.id.tue_list_view);
        wedListView = (ListView) findViewById(R.id.wed_list_view);
        thuListView = (ListView) findViewById(R.id.thu_list_view);
        friListView = (ListView) findViewById(R.id.fri_list_view);
        satListView = (ListView) findViewById(R.id.sat_list_view);
        sunAdapter = new ListAdapter(this, newSchedule.sunActivityList.toStringArray(), newSchedule.sunActivityList);
        monAdapter = new ListAdapter(this, newSchedule.monActivityList.toStringArray(), newSchedule.monActivityList);
        tueAdapter = new ListAdapter(this, newSchedule.tueActivityList.toStringArray(), newSchedule.tueActivityList);
        wedAdapter = new ListAdapter(this, newSchedule.wedActivityList.toStringArray(), newSchedule.wedActivityList);
        thuAdapter = new ListAdapter(this, newSchedule.thuActivityList.toStringArray(), newSchedule.thuActivityList);
        friAdapter = new ListAdapter(this, newSchedule.friActivityList.toStringArray(), newSchedule.friActivityList);
        satAdapter = new ListAdapter(this, newSchedule.satActivityList.toStringArray(), newSchedule.satActivityList);
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
                if(newSchedule.sunActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(newSchedule.sunActivityList.getActivity(position).getDescription());
                    if(newSchedule.sunActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                newSchedule.sunActivityList.getActivity(position).getStartHour() + ":0"
                                        + newSchedule.sunActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.sunActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                newSchedule.sunActivityList.getActivity(position).getStartHour() + ":"
                                        + newSchedule.sunActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.sunActivityList.getActivity(position).getStartAmPm());
                    }
                    if(newSchedule.sunActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                newSchedule.sunActivityList.getActivity(position).getStopHour() + ":0"
                                        + newSchedule.sunActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.sunActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                newSchedule.sunActivityList.getActivity(position).getStopHour() + ":"
                                        + newSchedule.sunActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.sunActivityList.getActivity(position).getStopAmPm());
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
                if(newSchedule.monActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(newSchedule.monActivityList.getActivity(position).getDescription());
                    if(newSchedule.monActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                newSchedule.monActivityList.getActivity(position).getStartHour() + ":0"
                                        + newSchedule.monActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.monActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                newSchedule.monActivityList.getActivity(position).getStartHour() + ":"
                                        + newSchedule.monActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.monActivityList.getActivity(position).getStartAmPm());
                    }
                    if(newSchedule.monActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                newSchedule.monActivityList.getActivity(position).getStopHour() + ":0"
                                        + newSchedule.monActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.monActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                newSchedule.monActivityList.getActivity(position).getStopHour() + ":"
                                        + newSchedule.monActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.monActivityList.getActivity(position).getStopAmPm());
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
                if(newSchedule.tueActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(newSchedule.tueActivityList.getActivity(position).getDescription());
                    if(newSchedule.tueActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                newSchedule.tueActivityList.getActivity(position).getStartHour() + ":0"
                                        + newSchedule.tueActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.tueActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                newSchedule.tueActivityList.getActivity(position).getStartHour() + ":"
                                        + newSchedule.tueActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.tueActivityList.getActivity(position).getStartAmPm());
                    }
                    if(newSchedule.tueActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                newSchedule.tueActivityList.getActivity(position).getStopHour() + ":0"
                                        + newSchedule.tueActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.tueActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                newSchedule.tueActivityList.getActivity(position).getStopHour() + ":"
                                        + newSchedule.tueActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.tueActivityList.getActivity(position).getStopAmPm());
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
                if(newSchedule.wedActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(newSchedule.wedActivityList.getActivity(position).getDescription());
                    if(newSchedule.wedActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                newSchedule.wedActivityList.getActivity(position).getStartHour() + ":0"
                                        + newSchedule.wedActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.wedActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                newSchedule.wedActivityList.getActivity(position).getStartHour() + ":"
                                        + newSchedule.wedActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.wedActivityList.getActivity(position).getStartAmPm());
                    }
                    if(newSchedule.wedActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                newSchedule.wedActivityList.getActivity(position).getStopHour() + ":0"
                                        + newSchedule.wedActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.wedActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                newSchedule.wedActivityList.getActivity(position).getStopHour() + ":"
                                        + newSchedule.wedActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.wedActivityList.getActivity(position).getStopAmPm());
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
                if(newSchedule.thuActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(newSchedule.thuActivityList.getActivity(position).getDescription());
                    if(newSchedule.thuActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                newSchedule.thuActivityList.getActivity(position).getStartHour() + ":0"
                                        + newSchedule.thuActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.thuActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                newSchedule.thuActivityList.getActivity(position).getStartHour() + ":"
                                        + newSchedule.thuActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.thuActivityList.getActivity(position).getStartAmPm());
                    }
                    if(newSchedule.thuActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                newSchedule.thuActivityList.getActivity(position).getStopHour() + ":0"
                                        + newSchedule.thuActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.thuActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                newSchedule.thuActivityList.getActivity(position).getStopHour() + ":"
                                        + newSchedule.thuActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.thuActivityList.getActivity(position).getStopAmPm());
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
                if(newSchedule.friActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(newSchedule.friActivityList.getActivity(position).getDescription());
                    if(newSchedule.friActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                newSchedule.friActivityList.getActivity(position).getStartHour() + ":0"
                                        + newSchedule.friActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.friActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                newSchedule.friActivityList.getActivity(position).getStartHour() + ":"
                                        + newSchedule.friActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.friActivityList.getActivity(position).getStartAmPm());
                    }
                    if(newSchedule.friActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                newSchedule.friActivityList.getActivity(position).getStopHour() + ":0"
                                        + newSchedule.friActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.friActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                newSchedule.friActivityList.getActivity(position).getStopHour() + ":"
                                        + newSchedule.friActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.friActivityList.getActivity(position).getStopAmPm());
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
                if(newSchedule.satActivityList.getActivity(position).getDescription().equals("default")) {
                    viewHolder.descriptionEditText.setText("");
                    viewHolder.startButton.setText("Start Time");
                    viewHolder.stopButton.setText("Stop Time");
                    viewHolder.addButton.setText("Add");
                    indexToBeUpdated = -1;
                }
                else {
                    viewHolder.descriptionEditText.setText(newSchedule.satActivityList.getActivity(position).getDescription());
                    if(newSchedule.satActivityList.getActivity(position).getStartMinute() < 10) {
                        viewHolder.startButton.setText(
                                newSchedule.satActivityList.getActivity(position).getStartHour() + ":0"
                                        + newSchedule.satActivityList.getActivity(position).getStartMinute()
                                        +newSchedule. satActivityList.getActivity(position).getStartAmPm());
                    }
                    else {
                        viewHolder.startButton.setText(
                                newSchedule.satActivityList.getActivity(position).getStartHour() + ":"
                                        + newSchedule.satActivityList.getActivity(position).getStartMinute()
                                        + newSchedule.satActivityList.getActivity(position).getStartAmPm());
                    }
                    if(newSchedule.satActivityList.getActivity(position).getStopMinute() < 10) {
                        viewHolder.stopButton.setText(
                                newSchedule.satActivityList.getActivity(position).getStopHour() + ":0"
                                        + newSchedule.satActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.satActivityList.getActivity(position).getStopAmPm());
                    }
                    else {
                        viewHolder.stopButton.setText(
                                newSchedule.satActivityList.getActivity(position).getStopHour() + ":"
                                        + newSchedule.satActivityList.getActivity(position).getStopMinute()
                                        + newSchedule.satActivityList.getActivity(position).getStopAmPm());
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
                sunAdapter = new ListAdapter(this,newSchedule.sunActivityList.toStringArray(), newSchedule.sunActivityList);
                sunListView.setAdapter(sunAdapter);
                sunListView.refreshDrawableState();
                break;
            case "Monday":
                monAdapter = new ListAdapter(this, newSchedule.monActivityList.toStringArray(), newSchedule.monActivityList);
                monListView.setAdapter(monAdapter);
                monListView.refreshDrawableState();
                break;
            case "Tuesday":
                tueAdapter = new ListAdapter(this, newSchedule.tueActivityList.toStringArray(), newSchedule.tueActivityList);
                tueListView.setAdapter(tueAdapter);
                tueListView.refreshDrawableState();
                break;
            case "Wednesday":
                wedAdapter = new ListAdapter(this, newSchedule.wedActivityList.toStringArray(), newSchedule.wedActivityList);
                wedListView.setAdapter(wedAdapter);
                wedListView.refreshDrawableState();
                break;
            case "Thursday":
                thuAdapter = new ListAdapter(this, newSchedule.thuActivityList.toStringArray(), newSchedule.thuActivityList);
                thuListView.setAdapter(thuAdapter);
                thuListView.refreshDrawableState();
                break;
            case "Friday":
                friAdapter = new ListAdapter(this, newSchedule.friActivityList.toStringArray(), newSchedule.friActivityList);
                friListView.setAdapter(friAdapter);
                friListView.refreshDrawableState();
                break;
            case "Saturday":
                satAdapter = new ListAdapter(this, newSchedule.satActivityList.toStringArray(), newSchedule.satActivityList);
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
