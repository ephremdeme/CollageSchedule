package com.example.testv2.viewModel;

import android.app.Application;

import com.example.testv2.model.Task;
import com.example.testv2.repository.TaskRepository;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class TaskDetailViewModel extends AndroidViewModel {

    TaskRepository repository;
    LiveData<Task> task;
    public TaskDetailViewModel(Application application) {
        super(application);
        repository=TaskRepository.getInstance(application);
    }

    public LiveData<Task> getTaskById(int id){
        System.out.println(id+ "view model");
        return repository.getTaskById(id);
    }
}
