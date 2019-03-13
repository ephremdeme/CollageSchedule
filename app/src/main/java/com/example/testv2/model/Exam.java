package com.example.testv2.model;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "exam")
public class Exam {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String subject;
    private Date date;
    private Date time;
    private int duration;
    private String room;

    @Ignore
    public Exam(String subject, Date date, Date time, int duration, String room) {
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.room = room;
    }

    public Exam(int id, String subject, Date date, Date time, int duration, String room) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.room = room;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
