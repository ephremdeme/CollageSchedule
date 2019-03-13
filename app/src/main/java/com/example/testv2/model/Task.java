package com.example.testv2.model;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String subject;
    private int progress;
    private String detail;
    private String type;
    private Date dueDate;

    @Ignore
    public Task(String subject, int progress, String detail, String type, Date dueDate) {
        this.subject = subject;
        this.progress = progress;
        this.detail = detail;
        this.type = type;
        this.dueDate = dueDate;
    }

    public Task(int id, String subject, int progress, String detail, String type, Date dueDate) {
        this.id = id;
        this.subject = subject;
        this.progress = progress;
        this.detail = detail;
        this.type = type;
        this.dueDate = dueDate;
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

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
