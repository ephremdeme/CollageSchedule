package com.example.testv2.viewModel;

import com.example.testv2.dao.TaskDao;
import com.example.testv2.model.Task;
import com.example.testv2.repository.TaskRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class TaskViewModel extends ViewModel {
    public TaskRepository repository;
    public LiveData<List<Task>> allTask;


    public TaskViewModel(TaskRepository repository){
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
}
