package com.example.testv2.repository;

import com.example.testv2.AppExecutors;

import com.example.testv2.dao.TaskDao;
import com.example.testv2.model.Exam;
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

    private  TaskRepository(TaskDao TaskDao, AppExecutors executors) {
        this.taskDao = TaskDao;
        this.executors=executors;
        executors.diskIO().execute(()->{
            allTask = this.taskDao.getAllTask();
        });

    }

    public static TaskRepository getInstance(TaskDao taskDao, AppExecutors executors){
        if (instance ==null){
            synchronized (LOCK){
                instance=new TaskRepository(taskDao, executors);
                return instance;
            }
        }
        return instance;
    }

    public LiveData<List<Task>> getAllTask() {
        return allTask;
    }


    public void insert (Task word) {
        executors.diskIO().execute(()->{
            taskDao.insert(word);
        });
    }

    public LiveData<Task> getTaskById(int id){
        executors.diskIO().execute(()->{
           task=taskDao.getTaskById(id);
        });
        return task;
    }


}