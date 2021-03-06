package com.example.alexh.hangout;

import java.io.Serializable;
import java.util.Calendar;

public class Profile implements Serializable{
    private boolean available;
    private boolean online;
    private boolean inGroup;
    //private Group group;
    private Schedule schedule;
    private String emailAddress;
    private String firstName;
    private String fullName;
    private String lastName;
    private String password;

    public Profile(){}

    public Profile(String emailAddress, String firstName, String lastName,
                   String password) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.fullName = firstName + " " + lastName;
        this.lastName = lastName;
        this.password = password;
    }

    public Profile(Schedule schedule, String emailAddress, String firstName, String lastName,
                   String password) {
        this.schedule = schedule;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.fullName = firstName + " " + lastName;
        this.lastName = lastName;
        this.password = password;
    }

    private void checkAvailability(Calendar time) {
        //check the activity list of the day to see if there is an activity at the given time
        //set "available" boolean variable accordingly
    }

    public boolean isAvailable() {
        Calendar time = Calendar.getInstance();
        checkAvailability(time);
        return available;
    }

    public boolean isOnline() {
        return online;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setAvailableStatus(boolean available) {
        this.available = available;
    }

    public void setOnlineStatus(boolean online) {
        this.online = online;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
}