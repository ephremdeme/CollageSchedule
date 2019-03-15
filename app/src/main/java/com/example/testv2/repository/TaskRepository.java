package com.example.testv2.repository;

import android.app.Application;
import android.util.Log;

import com.example.testv2.AppExecutors;

import com.example.testv2.database.TestDB;
import com.example.testv2.model.Task;

import java.util.List;

import androidx.lifecycle.LiveData;

public class TaskRepository {

    private static com.example.testv2.dao.TaskDao taskDao;
    private LiveData<List<Task>> allTask;
    private LiveData<Task> task;
    private static AppExecutors executors;

    private static   TaskRepository instance;
    private static Object LOCK =new Object();

    private    TaskRepository(Application application) {
        this.taskDao = TestDB.getInstance(application).getTaskDao();
        executors=AppExecutors.getInstance();
        allTask=taskDao.getAllTask();
    }
    public static TaskRepository getInstance(Application application){
        if (instance ==null){
            synchronized (LOCK){
                instance=new TaskRepository(application);
                return instance;
            }
        }
        return instance;
    }

    public LiveData<List<Task>> getAllTask() {

        Log.d(getClass().getName(), "Created");
        return allTask;
    }


    public void insert (Task word) {
        executors.diskIO().execute(()->{
            taskDao.insert(word);
        });
    }

    public LiveData<Task> getTaskById(int id){
        return taskDao.getTaskById(id);
    }

    public int count(){
        return allTask.getValue().size();
    }




}