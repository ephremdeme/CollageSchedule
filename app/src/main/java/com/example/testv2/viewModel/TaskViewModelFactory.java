package com.example.testv2.viewModel;

import com.example.testv2.repository.TaskRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class TaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    TaskRepository taskRepository;

    public TaskViewModelFactory(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TaskViewModel(taskRepository);
    }
}
