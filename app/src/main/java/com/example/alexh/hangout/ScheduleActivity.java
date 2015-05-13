package com.example.alexh.hangout;

public class ScheduleActivity {

    boolean isAm;
    int startHour;
    int startMinute;
    int stopHour;
    int stopMinute;
    String description;

    public ScheduleActivity(int startHour, int startMinute, int stopHour, int stopMinute,
                            String description, boolean isAm) {
        this.description = description;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.stopHour = stopHour;
        this.stopMinute = stopMinute;
        this.isAm = isAm;
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
        if(description.equals("default")) {
            return "+ New Activity";
        }
        else {
            return description + ":\n" + startHour + ":" + startMinute + "\nto\n" + stopHour + ":"
                    + stopMinute;
        }

    }
}
