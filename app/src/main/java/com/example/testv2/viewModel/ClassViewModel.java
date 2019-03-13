package com.example.testv2.viewModel;

import android.app.Application;

import com.example.testv2.model.ClassEntry;
import com.example.testv2.repository.ClassRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ClassViewModel extends ViewModel {

    ClassRepository repository;
    LiveData<ClassEntry> classEntryLiveData;
    LiveData<List<ClassEntry>> mAllClass;

    public ClassViewModel(ClassRepository repository) {
        this.repository = repository;
        mAllClass=repository.getAllWords();
    }

    public LiveData<List<ClassEntry>> getmAllClass() {
        return mAllClass;
    }

    public void insert(ClassEntry classEntry){
        repository.insert(classEntry);
    }
}
