package com.example.alexh.hangout;

public class ScheduleActivity {

    int startHour;
    int startMinute;
    int stopHour;
    int stopMinute;
    String startAmPm;
    String stopAmPm;
    String description;

    public ScheduleActivity(int startHour, int startMinute, String startAmPm, int stopHour, int stopMinute,
                             String stopAmPm, String description) {
        this.description = description;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.stopHour = stopHour;
        this.stopMinute = stopMinute;
        this.startAmPm = startAmPm;
        this.stopAmPm = stopAmPm;
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
        String returnString = "";
        if(description.equals("default")) {
            return "+ New Activity";
        }
        returnString += description + ":\n" + startHour + ":";
        if(startMinute < 10) {
            returnString += "0";
        }
        returnString += startMinute + startAmPm + "\nto\n" + stopHour + ":";
        if(stopMinute < 10) {
            returnString += "0";
        }
        returnString += stopMinute + stopAmPm;
        return returnString;
    }
}
