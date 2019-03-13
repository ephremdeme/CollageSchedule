package com.example.testv2.model;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "class")
public class ClassEntry {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String subject;
    private String room;
    private String building;
    private boolean repeat;
    private String days;
    private Date startTime;
    private Date endTime;

    @Ignore
    public ClassEntry(String subject, String room, String building, boolean repeat, String days, Date startTime, Date endTime) {
        this.subject = subject;
        this.room = room;
        this.building = building;
        this.repeat = repeat;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public ClassEntry(int id, String subject, String room, String building, boolean repeat, String days, Date startTime, Date endTime) {
        this.id = id;
        this.subject = subject;
        this.room = room;
        this.building = building;
        this.repeat = repeat;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
