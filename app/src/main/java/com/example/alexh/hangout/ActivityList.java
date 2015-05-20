package com.example.alexh.hangout;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivityList {

    ArrayList<ScheduleActivity> schedule;

    public ActivityList() {
        schedule = new ArrayList<>();
        ScheduleActivity defaultActivity = new ScheduleActivity(999, 999, "pm", 0, 0, "pm", "default");
        schedule.add(defaultActivity);
    }

    public void addActivity(ScheduleActivity activity) {
        int position = 0;
        if(schedule.size() > 0) {
            while(activity.startAmPm.equals("pm") && schedule.get(position).startAmPm.equals("am")) {
                position++;
            }
            while(activity.getStartHour() > schedule.get(position).getStartHour()) {
                position++;
            }
            while(activity.getStartMinute() > schedule.get(position).getStartMinute()
                    && activity.getStartHour() == schedule.get(position).getStartHour()) {
                position++;
            }
            schedule.add(position, activity);
        }
        else {
            schedule.add(activity);
        }
    }

    public ScheduleActivity getActivity(int index) {
        return schedule.get(index);
    }

    public int getSize() {
        return schedule.size();
    }

    public boolean replace(int position, ScheduleActivity newActivity) {
        if(position >= schedule.size()) {
            return false;
        }
        else {
            schedule.remove(position);
            addActivity(newActivity);
            return true;
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
