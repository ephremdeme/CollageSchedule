package com.example.testv2.viewModel;

import com.example.testv2.repository.ClassRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ClassViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    ClassRepository repository;

    public ClassViewModelFactory(ClassRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ClassViewModel(repository);
    }
}
