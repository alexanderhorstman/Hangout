package com.example.alexh.hangout;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivityList {

    ArrayList<ScheduleActivity> schedule;

    public ActivityList() {
        schedule = new ArrayList<>();
    }

    public void addActivity(ScheduleActivity activity) {
        int position = 0;
        if(schedule.size() > 0) {
            while(activity.getStartHour() > schedule.get(position).getStartHour()) {
                position++;
            }
            while(activity.getStartMinute() > schedule.get(position).getStartMinute()) {
                position++;
            }
            schedule.add(position, activity);
        }
        else {
            schedule.add(activity);
        }
    }

    public String[] toStringArray() {
        String[] array = new String[schedule.size()];
        for(int i =  0; i < schedule.size(); i++) {
            array[i] = schedule.get(i).toString();
        }
        return array;
    }
}
