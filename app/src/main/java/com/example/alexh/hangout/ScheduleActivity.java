package com.example.alexh.hangout;

public class ScheduleActivity {

    int startHour;
    int startMinute;
    int stopHour;
    int stopMinute;
    String description;

    public ScheduleActivity( String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getStartHour() {
        return  startHour;
    }
    
    public int getStartMinute() {
        return startMinute;
    }

    public int getStopHour() {
        return stopHour;
    }

    public int getStopMinute() {
        return  stopMinute;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public void setStopHour(int stopHour) {
        this.stopHour = stopHour;
    }

    public void setStopMinute(int stopMinute) {
        this.stopMinute = stopMinute;
    }

    public String toString() {
        return description + ":\n" + startHour + ":" + startMinute + "\nto\n" + stopHour + ":"
                + stopMinute;
    }
}
