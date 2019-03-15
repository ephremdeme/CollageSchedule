package com.example.testv2;

import android.app.Application;

import com.example.testv2.model.ClassEntry;
import com.example.testv2.repository.ClassRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ClassDetailViewModel extends AndroidViewModel {

    ClassRepository repository;

    public ClassDetailViewModel(@NonNull Application application) {
        super(application);
        repository=ClassRepository.getInstance(application);
    }

    LiveData<ClassEntry> getClassById(int id){
        return repository.getClassById(id);
    }
}
