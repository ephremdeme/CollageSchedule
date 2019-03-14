package com.example.testv2.viewModel;

import android.app.Application;

import com.example.testv2.model.Task;
import com.example.testv2.repository.TaskRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TaskViewModel extends AndroidViewModel {
    public TaskRepository repository;
    public LiveData<List<Task>> allTask;


    public TaskViewModel(Application application){
        super(application);
        repository=TaskRepository.getInstance(application);
        allTask=repository.getAllTask();
    }

    public void insert(Task task){
        repository.insert(task);
    }

    public LiveData<Task> getTaskById(int id){
        return repository.getTaskById(id);
    }

    public LiveData<List<Task>> getAllTask() {
        return allTask;
    }
    public int count(){
        return repository.count();
    }
}
