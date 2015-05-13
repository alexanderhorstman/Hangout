package com.example.alexh.hangout;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivityList {

    ArrayList<ScheduleActivity> schedule;

    public ActivityList() {
        schedule = new ArrayList<>();
        ScheduleActivity defaultActivity = new ScheduleActivity(999, 999, 0, 0, "default", false);
        schedule.add(defaultActivity);
    }

    public void addActivity(ScheduleActivity activity) {
        int position = 0;
        if(schedule.size() > 0) {
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

    public String[] toStringArray() {
        String[] array = new String[schedule.size()];
        for(int i =  0; i < schedule.size(); i++) {
            array[i] = schedule.get(i).toString();
        }
        return array;
    }
}
